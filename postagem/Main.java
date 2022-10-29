
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {


        Leitor leitores = new Leitor();
        ArrayList<String> emails = leitores.read();
        Aluno aluno = new Aluno(args[1]);
        Group gruop = new Group();

        for (String email: emails) {
            gruop.add(new Aluno(email));
        }

        if (args[0].equals("add")) {
            gruop.add(aluno);
            leitores.gravar(args[1]);
            System.out.println(aluno.getEmail() + " foi adicionado(a) ao grupo.");
            gruop.printAlunos();
        }

        else if (args[0].equals("del")) {
            gruop.del(aluno);
            leitores.deletar(args[1]);
            System.out.println(aluno.getEmail() + " foi removido(a) do grupo.");
            gruop.printAlunos();
        }
        else if (args[0].equals("msg")) {
            gruop.notificarAlunos(args[2], aluno.getEmail());
        }

    }
}

