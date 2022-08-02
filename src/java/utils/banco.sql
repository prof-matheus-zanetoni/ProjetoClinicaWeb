create table atividadePrincipal(
    codigoAtividadePrincipal serial not null primary key,
    descricaoAtividadePrincipal varchar not null
);

create table pessoa(
    codigoPessoa serial not null primary key,
    nomePessoa varchar not null,
    dataNascimentoPessoa date not null,
    cpfPessoa varchar not null,
    senhaPessoa varchar not null
);

create table paciente(
    codigoPaciente int not null primary key references pessoa(codigoPessoa),
    numeroCartaoSusPaciente varchar not null,
    statusPaciente boolean not null,
    codigoAtividadePrincipal int not null references atividadePrincipal(codigoAtividadePrincipal)
);

create table medico(
    codigoMedico int not null primary key references pessoa(codigoPessoa),
    crmMedico varchar not null,
    statusMedico boolean not null
);

create table consulta(
    codigoConsulta serial not null primary key,
    dataConsulta date not null,
    horarioConsulta time not null,
    situacaoConsulta varchar not null,
    observacoesConsulta varchar not null,
    codigoPaciente int not null references paciente(codigoPaciente),
    codigoMedico int not null references medico(codigoMedico)
);

create or replace procedure cadastrarAtividadePrincipal(codigo_Atividade_Principal int, descricao_Atividade_Principal varchar) as $$
    begin
        if codigo_Atividade_Principal > 0 then
            update atividadeprincipal set descricaoatividadeprincipal = descricao_Atividade_Principal where codigoatividadeprincipal = codigo_Atividade_Principal;
        else
            insert into atividadeprincipal values(default, descricao_Atividade_Principal);
        end if;
    end;
$$ language plpgsql;

create or replace function cadastrarPessoa(codigo_Pessoa int, nome_Pessoa varchar, data_Nascimento_Pessoa date, cpf_Pessoa varchar, senha_Pessoa varchar) returns int as $$
    declare
        retornoCodigoPessoa int := 0;
    begin
        if codigo_Pessoa > 0 then
            update pessoa set nomePessoa = nome_Pessoa, dataNascimentoPessoa = data_Nascimento_Pessoa, cpfPessoa = cpf_Pessoa, senhaPessoa = senha_Pessoa where codigopessoa = codigo_Pessoa returning codigoPessoa into retornoCodigoPessoa;
        else
            insert into pessoa values(default, nome_Pessoa, data_Nascimento_Pessoa, cpf_Pessoa, senha_Pessoa) returning codigoPessoa into retornoCodigoPessoa;
        end if;
        return retornoCodigoPessoa;
    end;
$$ language plpgsql;

create or replace procedure cadastrarPaciente(codigo_Pessoa int, nome_Pessoa varchar, data_Nascimento_Pessoa date, cpf_Pessoa varchar, senha_Pessoa varchar, numero_Cartao_Sus_Paciente varchar, status_Paciente boolean, codigo_Atividade_Principal int) as $$
    declare
        idPaciente int := 0;
        idPessoa int := 0;
    begin
        select into idPaciente codigopaciente from paciente where codigopaciente = codigo_Pessoa;
        select into idPessoa codigopessoa from pessoa where codigopessoa = codigo_Pessoa;
        if idPaciente > 0 and idPessoa > 0 then
            update paciente set codigopaciente = (select cadastrarPessoa(codigo_Pessoa, nome_Pessoa, data_Nascimento_Pessoa, cpf_Pessoa, senha_Pessoa)), numerocartaosuspaciente = numero_Cartao_Sus_Paciente, statuspaciente = status_Paciente, codigoatividadeprincipal = codigo_Atividade_Principal where codigopaciente = codigo_Pessoa;
        else
            insert into paciente values((select cadastrarPessoa(codigo_Pessoa, nome_Pessoa, data_Nascimento_Pessoa, cpf_Pessoa, senha_Pessoa)), numero_Cartao_Sus_Paciente, status_Paciente, codigo_Atividade_Principal);
        end if;
    end;
$$ language plpgsql;