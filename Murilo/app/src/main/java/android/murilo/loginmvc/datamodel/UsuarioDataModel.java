package android.murilo.loginmvc.datamodel;

public class UsuarioDataModel {


    // Toda Classe DataModel tem essa estrutura;
    // 1 - Atributo nome da Tabela
    // 2 - Atributos um para um com os nomes dos campos
    // 3 - Query para criar a tabela no banco de dados
    // 4 - Metodod para gerar o script para criar a tabela

    // 1
    public static final String TABELA = "usuarios";

    //2
    public static final String ID = "id";
    public static final String NOME= "nome";
    public static final String EMAIL = "email";
    public static final String SENHA = "email";

    //3
    public static String queryCriarTabela = "";

    //4
    public static String criarTabela(){
        // Concatenação de Strings
        queryCriarTabela += "CREATE TABLE " + TABELA + "(";
        queryCriarTabela += ID    + " integer primary key autoincrement, ";
        queryCriarTabela += NOME  + " text, ";
        queryCriarTabela += EMAIL + " Text ";
        queryCriarTabela += SENHA + " Text ";
        queryCriarTabela += ")";

        return queryCriarTabela;

    }
}
