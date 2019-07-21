package blood;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author WESLLES
 */


/** ***** ANOTAÇÕES *****
 * 1) Setar Status Clínico (Operação forçada na inserção de doador e receptor)
 * 2) Verificar implementação do Método Examinar 
 * 3) Atualmente uma lista só não pode conter Doador e Receptor (é o desejado?)
 * 4) 
 */
public class Fachada {
    Scanner ler = new Scanner(System.in);
    String l = "123";
    String s = "123";
    String opcao;
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date;
    String cPF;
    BancoDeSangue banco = new BancoDeSangue();
    Freezer f = new Freezer();
    CadastroPessoa bdPessoa = CadastroPessoa.getInstancia();
    Apessoa pessoa;
        
    public void menu() throws BloodTypeNotFoundException, BloodNotEnoughException
    {
       boolean continueLoop;
        do{
            
            System.out.println("\n\n\n*** Menu Principal - Banco de Sangue ***\n");
            System.out.println("1 - Cadastrar Doador");
            System.out.println("2 - Cadastrar Receptor");
            System.out.println("3 - Doar Sangue");
            System.out.println("4 - Receber Sangue");
            System.out.println("5 - Entrar como Administrador");
            System.out.println("0 - Sair do Sistema");
            System.out.println("\nInforme sua opção:");
            opcao = ler.nextLine();
            switch(opcao){
                case "1":{
                   do{
                        try {
                            System.out.println("Entre com seu CPF: ");
                            cPF = ler.next();
                            if(cPF.length() != 11){
                             continueLoop = true; 
                             System.out.println("***** CPF INVALIDO **** \n\n");
                            }else{
                            Long.parseLong(cPF);
                            continueLoop = false;
                            }
                        }catch (NumberFormatException e) { 
                            continueLoop = true; 
                            System.out.println("***** CPF INVALIDO **** \n\n");
                          }
                    }while(continueLoop);
                 
                    if(bdPessoa.contido(cPF) != null){
                        System.out.println("Pessoa ja Cadastrada");
                        if(bdPessoa.contido(cPF).getUltimaTransfusao() == null){
                            Doador d = new Doador();
                            cast(d, bdPessoa.contido(cPF));
                        }
                    }
                    else {
                        String name;
                        int idd;
                        float massa;
                        String sexo;
                        Sangue sa;
                        String data;
                        String tipoSangue;
                        pessoa = new Doador();
                        System.out.println("\n**** CADASTRO DE DOADOR ****\n");
                        System.out.println("Informe seu nome: ");
                        ler.nextLine(); // Erro concertado;
                        name = ler.nextLine();
                        System.out.println("\nInforme sua Idade: ");
                        idd = ler.nextInt();
                        System.out.println("\nInforme seu Peso: ");
                        massa = ler.nextFloat();
                        System.out.println("\nInforme seu Sexo: ");
                        ler.nextLine();
                        sexo = ler.nextLine();
                        System.out.println("\nInforme seu Tipo Sanguineo: ");
                        tipoSangue = ler.nextLine();   
                        
                        System.out.println("\nInforme a data da sua ultima Doação: (DD/MM/AAAA) \nSe nunca doou, digite 01/01/0001");
                        data = ler.nextLine();
                        date = LocalDate.parse(data, formatador);
                        pessoa.setPeso(massa);
                        sa = new Sangue(tipoSangue, 1);
                        boolean test;
                        test = pessoa.examinar();
                        if(test){
                            pessoa = new Doador(name, cPF, idd, massa, test, sexo, sa, date);
                            bdPessoa.insert(pessoa);
                        }else
                            System.out.println("Não pode ser doador!");
                        
                    }
                }break;
                
                case "2":{
                    System.out.println("**** CADASTRO DE RECEPTOR ****\n");
                    do{
                        try {
                            System.out.println("Entre com seu CPF: ");
                            cPF = ler.next();
                            if(cPF.length() != 11){
                             continueLoop = true; 
                             System.out.println("***** CPF INVALIDO **** \n\n");
                            }else{
                            Long.parseLong(cPF);
                            continueLoop = false;
                            }
                        }catch (NumberFormatException e) { 
                            continueLoop = true; 
                            System.out.println("***** CPF INVALIDO **** \n\n");
                          }
                    }while(continueLoop);
                    if(bdPessoa.contido(cPF) != null)
                        System.out.println("Pessoa ja Cadastrada!");
                    else{
                        String name;
                        int idd;
                        float massa;
                        String sexo;
                        Sangue sa;
                        String data;
                        String tipoSangue;

                        System.out.println("\n**** CADASTRO DE RECEPTOR ****\n");
                        System.out.println("Informe seu nome: ");
                        ler.nextLine();//erro concertado
                        name = ler.nextLine();
                        System.out.println("\nInforme sua Idade: ");
                        idd = ler.nextInt();
                        System.out.println("\nInforme seu Peso: ");
                        massa = ler.nextFloat();
                        System.out.println("\nInforme seu Sexo: ");
                        ler.nextLine();
                        sexo = ler.nextLine();
                        System.out.println("\nInforme seu Tipo Sanguineo: ");
                        tipoSangue = ler.nextLine();
                        
                        sa = new Sangue(tipoSangue, 0);//QUANTIDADE NÃO NECESSÁRIA NO CADASTRO
                        pessoa = new Receptor(name, cPF, idd, massa, sexo, sa);
                        bdPessoa.insert(pessoa);
                        
                        //NECESSITA SETAR STATUS CLINICO
                    }
                }break;
                
                case "3":{
                    /**
                     * peso, ultimatransfusão, tatuagem, idade (MÉTODO EXAMINAR)
                     * APÓS EXAME RETORNAR NULL SE NÃO PUDER DOAR E freezer SE PUDER DOAR 
                     */
                    
                    System.out.println("\n**** DOAÇÃO DE SANGUE ****\n\n");
                    do{
                        try {
                            System.out.println("Informe o CPF: ");
                            cPF = ler.next();
                            if(cPF.length() != 11){
                             continueLoop = true; 
                             System.out.println("***** CPF INVALIDO **** \n\n");
                            }else{
                            Long.parseLong(cPF);
                            continueLoop = false;
                            }
                        }catch (NumberFormatException e) { 
                            continueLoop = true; 
                            System.out.println("***** CPF INVALIDO **** \n\n");
                          }
                    }while(continueLoop); 
                    if(bdPessoa.contido(cPF) != null){
                        Doador doa;
                        doa = castD(bdPessoa.contido(cPF));
                        
                        if(doa.calculoUltimaTransfusao() >=3){
                            doa.doarSangue(banco);
                            bdPessoa.contido(cPF).ultimaTransfusao = LocalDate.now();
                        }
                        else{
                            System.out.println("Impossível doar!\nVolte em: "+(doa.calculoUltimaTransfusao())+"meses");
                        }
                    }else{
                        System.out.println("Usuario não cadastrado!!");
                    }
                    
                }break;
                
                case "4":{
                    String tipoSangue;
                    int quantidade;
                    Sangue sangue;
                    System.out.println("\n**** RECEPÇÃO DE SANGUE ****\n\n");
                    String cpf = null;
                    do{
                        try {
                            System.out.println("Infome o CPF: ");
                            cpf = ler.nextLine();
                            if(cpf.length() != 11){
                             continueLoop = true; 
                             System.out.println("***** CPF INVALIDO **** \n\n");
                            }else{
                            Long.parseLong(cpf);
                            continueLoop = false;
                            }
                        }catch (NumberFormatException e) { 
                            continueLoop = true; 
                            System.out.println("***** CPF INVALIDO **** \n\n");
                          }
                    }while(continueLoop);
                    if(bdPessoa.contido(cpf) != null){
                        System.out.println("Informe a quantidade: ");
                        quantidade = ler.nextInt();
                        ler.nextLine();
                        Receptor aux = castR(bdPessoa.contido(cpf));
                        aux.receberSangue(banco, quantidade); 
                    }else{
                        System.out.println("Usuario não cadastrado");
                    }
                   
                }break;
                case "5":{
                    System.out.println("\n**** USUÁRIO ADMINISTRADOR ****\n\n");
                    System.out.println("Entre com o login do Administrador: ");
                    String login = ler.nextLine();
                    System.out.println("Entre com a senha:");
                    String senha = ler.nextLine();
                    
                    this.menuADM(login, senha);
                    
                }break;
                default:
                    if ("0".equals(opcao))
                    System.out.println( "\nFechando Sistema...");
                    else
                        System.out.println("\nOpção Inválida! Tente Novamente!\n\n");
            }
        }while(!"0".equals(opcao));
        
    }

     
    public Apessoa cast(Apessoa d, Apessoa r){ // d = Destino(é o tipo que vc quer ), r = Origem(o tipo que vc tem);
        d.cpf = r.cpf;
        d.genero = r.genero;
        d.idade = r.idade;
        d.genero = r.genero;
        d.nome = r.nome;
        d.peso = r.peso;
        d.statusClinico = r.statusClinico;
        d.sangue = r.sangue;
        d.ultimaTransfusao = r.ultimaTransfusao;
        
        return d;
    }
    
    
    public Doador castD(Apessoa r){ // r  =  é o tipo original
        Doador d = new Doador();
        d.cpf = r.cpf;
        d.genero = r.genero;
        d.idade = r.idade;
        d.genero = r.genero;
        d.nome = r.nome;
        d.peso = r.peso;
        d.statusClinico = r.statusClinico;
        d.sangue = r.sangue;
        d.ultimaTransfusao = r.ultimaTransfusao;
        
        return d;
    }
    
    public Receptor castR(Apessoa d){ // d = é o tipo original
        Receptor r = new Receptor();
        r.cpf = d.cpf;
        r.genero = d.genero;
        r.idade = d.idade;
        r.genero = d.genero;
        r.nome = d.nome;
        r.peso = d.peso;
        r.statusClinico = d.statusClinico;
        r.sangue = d.sangue;
        r.ultimaTransfusao = d.ultimaTransfusao;
        
        return r; // O retorno é o tipo que se deseja
    }
    
    public void menuADM(String login, String senha ){
        
        String opc;
        if(!login.equals(l)){
            System.out.println("Login inválido");
        }
        else
            if(!senha.equals(s))
                System.out.println("Senha inválida");
            else

                do{
                    
                    System.out.println("\n\n\n*** Administração - Banco de Sangue ***\n");
                    System.out.println("1 - Listar Freezrs disponiveis");
                    System.out.println("2 - Listar pessoas Cadastradas");
                    System.out.println("3 - Consultar CPF especifico");
                    System.out.println("4 - Alterar Login");
                    System.out.println("5 - Alterar Senha");
                    System.out.println("0 - Voltar ao menu anterior");
                    System.out.println("\nInforme sua opção:");
                    opc = ler.nextLine();

                    switch(opc)
                    {
                        case "1":
                            banco.listarFreezer();
                        break;

                        case "2":
                            System.out.println("\n****Lista de Pessoas Cadastradas****\n");
                            for (Apessoa apessoa : bdPessoa.listar()) {
                                System.out.println("Nome: "+ apessoa.getNome());
                                System.out.println("CPF: "+apessoa.getCPF());
                                System.out.println("Genero: "+apessoa.getGenero());
                                System.out.println("Idade: "+apessoa.getIdade()+" anos");
                                System.out.println("Peso: "+apessoa.getPeso()+" Kg");
                                System.out.println("Tipo Sanguineo: "+ apessoa.sangue.getTipagemSanguinea());
                                System.out.println("Ultima Transfusão: "+apessoa.getUltimaTransfusao().format(formatador));
                                System.out.println("--------------------");
                            }
                            break;
                        case "3":
                            System.out.println("Entre com seu CPF: ");
                            cPF = ler.nextLine();
                            try{
                               while(cPF.length() != 11){
                                   System.out.println("***** CPF INVALIDO ****\n\n");
                                   System.out.println("Entre com seu CPF: ");
                                    cPF = ler.nextLine();
                               }
                               if(bdPessoa.contido(cPF) == null)
                                    System.out.println("Pessoa não Cadastrada");
                                else{
                                    System.out.println("\n***** Consulta de Pessoa Especifica*****\n");
                                    Apessoa apessoa = bdPessoa.contido(cPF);
                                    System.out.println("Nome: "+ apessoa.getNome());
                                    System.out.println("CPF: "+apessoa.getCPF());
                                    System.out.println("Genero: "+apessoa.getGenero());
                                    System.out.println("Idade: "+apessoa.getIdade()+" Anos");
                                    System.out.println("Peso: "+apessoa.getPeso()+" Kg");
                                    System.out.println("Tipo Sanguineo: "+ apessoa.sangue.getTipagemSanguinea());
                                    System.out.println("Ultima Transfusão: "+apessoa.getUltimaTransfusao().format(formatador));
                                    System.out.println("--------------------");
                            }
                            }catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            
                            break;
                        case "4":
                            System.out.println("Entre com o login atual:");
                            String log = ler.nextLine();
                            if(log.equals(l)){
                                
                                boolean validation = false;
                                do{
                                    System.out.println("Entre com o novo login: ");
                                    log = ler.nextLine();
                                    if("0".equals(log))
                                        break;
                                    System.out.println("Digite novamente o novo login: ");
                                    String t = ler.nextLine();
                                    if(log.equals(t)){
                                        this.l = log;
                                        validation = true;
                                        System.out.println("Login modificado com sucesso!!");
                                    }else{
                                        validation = false;
                                        System.out.println("Logins diferentes, por favor digite novamente\n ou pressione 0 para cancelar");
                                    }
                                }while(!validation);    
                            }else
                                System.out.println("Login incorreto, por favor escolha novamente a opção!!");
                            break;
                        case "5":
                            System.out.println("Entre com a senha atual:");
                            String password = ler.nextLine();
                            
                            
                            if(password.equals(s)){
                                
                                boolean validation = false;
                                do{
                                    System.out.println("Entre com a nova senha: ");
                                    password = ler.nextLine();
                                    if("0".equals(password))
                                        break;
                                    System.out.println("Digite novamente a nova senha: ");
                                    String t = ler.nextLine();
                                    if(password.equals(t)){
                                        this.s = password;
                                        validation = true;
                                        System.out.println("Senha modificada com sucesso!!");
                                    }else{
                                        validation = false;
                                        System.out.println("Senhas diferentes, por favor digite novamente \n ou pressione 0 para cancelar");
                                    }
                                }while(!validation);    
                            }else
                                System.out.println("Senha incorreta, por favor escolha novamente a opção!!");
                            break;
                        default:
                                if ("0".equals(opc))
                                System.out.println( "\nSaindo do modo ADM!");
                                else
                                    System.out.println("\nOpção Inválida! Tente Novamente!\n\n");
                                break;
                    }
                }while(!"0".equals(opc));
    }
}
