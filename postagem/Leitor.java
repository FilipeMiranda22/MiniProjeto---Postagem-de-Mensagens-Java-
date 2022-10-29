import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Leitor {

    String fileName = "Lista.txt";

    public ArrayList<String> read() throws IOException {
        File file = new File(fileName);
        file.createNewFile();
        Scanner scan = new Scanner(file);
        ArrayList<String> alunos = new ArrayList<>();

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            alunos.add(line);
        }

        scan.close();
        return alunos;
    }

    public void gravar(String aluno) throws IOException {
        File f = new File(fileName);
        FileWriter arq = new FileWriter(f, true);
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.printf("%s%n", aluno);
        arq.close();
    }

    public void deletar(String aluno) throws IOException{

        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader leitor = null;
        File arquivo = new File(fileName);

        String arquivoConferir = "ListaTemp.txt";
        String line = "";

        File novoArquivo = new File(arquivoConferir);

        try {

            fileReader = new FileReader(arquivo);
            fileWriter = new FileWriter(novoArquivo);
            leitor = new BufferedReader(fileReader);
            line = "";

            while ((line = leitor.readLine()) != null) {
                if(!line.trim().equals(aluno.trim())) {
                    fileWriter.write(line + "\r\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally   {
            try {
                fileWriter.close();
                fileReader.close();
                arquivo.delete();
                novoArquivo.renameTo(new File(fileName));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
