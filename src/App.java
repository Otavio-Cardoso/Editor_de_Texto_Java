import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner leia = new Scanner(System.in);
        String caixaDeTxt[] = new String[200], textop = "";
        int linha;
        System.out.println("Digite o texto: ");
        for (int i = 0; i < caixaDeTxt.length; i++) {
            caixaDeTxt[i] = leia.nextLine();
            if (caixaDeTxt[i].equals("//fim//")) {
                caixaDeTxt[i] = null;
                for (int j = 0; j < caixaDeTxt.length; j++) {
                    if (caixaDeTxt[j] != null)
                        textop += caixaDeTxt[j] + "\n";
                }
                escrever(textop);
                break;
            }
            if (i == caixaDeTxt.length - 1) {
                System.out.println("Limite de texto atingido");
                break;
            }
            if (caixaDeTxt[i].equals("//editar//")) {
                caixaDeTxt[i] = null;
                System.out.println("Qual linha deseja editar?");
                linha = leia.nextInt();
                leia.nextLine();
                System.out.println("Digite a correção do texto: ");
                caixaDeTxt[linha] = leia.nextLine();
                i--;
            }
            exibirTexto(caixaDeTxt);
        }
        leia.close();
    }
    public static void escrever(String texto) throws IOException {
        Path caminho = Paths.get("src\\texto.txt");
        Files.write(caminho, texto.getBytes(), StandardOpenOption.CREATE);
    }
    public static void exibirTexto(String[] caixaDeTxt) {
        for (int j = 0; j < caixaDeTxt.length; j++) {
            if (caixaDeTxt[j] != null) {
                System.out.println(j + " " + caixaDeTxt[j]);
            }
        }
    }
}
