import javax.swing.JOptionPane;

public class Produto {
    private String nome;
    private double preco;
    private String descricao;

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void aumentarPreco(double percentual){
        this.preco *= (1 + percentual/100);
    }

    public void mostrarDados(){
        String mensagem = "Nome: " + nome + "\n" +
                          "Descrição: " + descricao + "\n" +
                          "Preço: R$" + preco;
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Digite o nome do produto");
        String descricao = JOptionPane.showInputDialog("Digite a descrição do produto");

        Produto p1 = new Produto(nome, descricao);;

        double menorPreco = Double.MAX_VALUE;
        double preco;
        do {
            preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto (digite 0 para sair):"));
            if(preco != 0 && preco < menorPreco){
                menorPreco = preco;
            }
        } while(preco != 0);

        p1.setPreco(menorPreco);
        p1.aumentarPreco(2);
        p1.mostrarDados();
    }

    
}
