
import java.util.ArrayList;
import java.util.Objects;


public class Group {

    private ArrayList <Aluno> participantes;

    public Group() {
        this.participantes = new ArrayList<>();
    }

    public void add(Aluno aluno) {
        participantes.add(aluno);
    }

    public void del(Aluno aluno) {
        participantes.removeIf(a-> Objects.equals(a.getEmail(), aluno.getEmail()));
    }

    public void printAlunos(){
        System.out.println("\n========== Lista de Alunos no Grupo ==========");
        for (Aluno participante: participantes) {
            System.out.println(participante.getEmail() + " Está ativo no grupo");
        }
        System.out.println("===============================================\n");
    }

    public void notificarAlunos(String mensagem, String autor){
        for (Observador participante: participantes) {
            participante.update(mensagem, autor);
        }
    }

    public ArrayList<Aluno> getParticipantes() {
        return participantes;
    }
}

