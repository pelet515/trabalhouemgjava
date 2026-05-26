import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AppCadastro extends Application {

    // Classe interna Pessoa para manter tudo em um único arquivo, como permitido
    class Pessoa {
        String nome, cpf, email, telefone;

        public Pessoa(String nome, String cpf, String email, String telefone) {
            this.nome = nome;
            this.cpf = cpf;
            this.email = email;
            this.telefone = telefone;
        }

        @Override
        public String toString() {
            return "Nome: " + nome + " | CPF: " + cpf + " | E-mail: " + email + " | Tel: " + telefone;
        }
    }

    // Lista em memória para armazenar as pessoas cadastradas
    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cadastro de Pessoas");

        // Criando os campos de texto
        TextField txtNome = new TextField();
        TextField txtCpf = new TextField();
        TextField txtEmail = new TextField();
        TextField txtTelefone = new TextField();

        // Organizando os rótulos e campos na tela
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        grid.add(new Label("Nome:"), 0, 0);
        grid.add(txtNome, 1, 0);
        grid.add(new Label("CPF:"), 0, 1);
        grid.add(txtCpf, 1, 1);
        grid.add(new Label("E-mail:"), 0, 2);
        grid.add(txtEmail, 1, 2);
        grid.add(new Label("Telefone:"), 0, 3);
        grid.add(txtTelefone, 1, 3);

        // Criando os botões
        Button btnSalvar = new Button("Salvar");
        Button btnCancelar = new Button("Cancelar");
        Button btnListar = new Button("Listar");

        // --- LÓGICA DE EVENTOS (O que cada botão faz) ---

        // Botão Salvar
        btnSalvar.setOnAction(e -> {
            // Capturando os valores com getText()
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String email = txtEmail.getText();
            String telefone = txtTelefone.getText();

            // Criando o objeto Pessoa e adicionando na lista
            Pessoa novaPessoa = new Pessoa(nome, cpf, email, telefone);
            listaPessoas.add(novaPessoa);
            
            System.out.println("Pessoa salva com sucesso!");
            
            // Limpa os campos após salvar
            txtNome.clear();
            txtCpf.clear();
            txtEmail.clear();
            txtTelefone.clear();
        });

        // Botão Cancelar (Limpar os campos)
        btnCancelar.setOnAction(e -> {
            txtNome.clear();
            txtCpf.clear();
            txtEmail.clear();
            txtTelefone.clear();
            System.out.println("Operação cancelada. Campos limpos.");
        });

        // Botão Listar (Exibir no console)
        btnListar.setOnAction(e -> {
            System.out.println("--- Lista de Pessoas Cadastradas ---");
            if (listaPessoas.isEmpty()) {
                System.out.println("Nenhuma pessoa cadastrada ainda.");
            } else {
                for (Pessoa p : listaPessoas) {
                    System.out.println(p.toString());
                }
            }
            System.out.println("------------------------------------");
        });

        // Organizando os botões lado a lado
        HBox boxBotoes = new HBox(10);
        boxBotoes.getChildren().addAll(btnSalvar, btnCancelar, btnListar);

        // Juntando o formulário com os botões
        VBox layoutPrincipal = new VBox(15);
        layoutPrincipal.setPadding(new Insets(10));
        layoutPrincipal.getChildren().addAll(grid, boxBotoes);

        // Exibindo a janela
        Scene scene = new Scene(layoutPrincipal, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
