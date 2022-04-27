create table atividadePrincipal(
    codigoAtividadePrincipal serial not null primary key,
    descricaoAtividadePrincipal varchar not null
);

create table pessoa(
    codigoPessoa serial not null primary key,
    nomePessoa varchar not null,
    dataNascimentoPessoa date not null,
    cpfPessoa varchar not null unique,
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