import java.io.File;

public class Aluno implements Observador{

    private String email;

    public Aluno(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void update(String mensagem, String autor) {
        System.out.println(autor + " enviou uma mensagem no Grupo que foi recebida por "
                + this.email + ": " + mensagem);
    }
}
