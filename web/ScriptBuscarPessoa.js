$("input#cpfPessoa").blur(function () {
   let cpfPessoa = $(this).val();
   $.getJSON("BuscarPessoa", {cpfPessoa: cpfPessoa}, function (resp) {
       if(resp.erro === undefined) {
           
       } else {
           alert(resp.erro);
       }
   });
});