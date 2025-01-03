package br.com.dio.java.io.IOCharacter;


import java.io.*;

//Faça uma cópia do arquivo “recomendacoes.txt” e agora adicione 3 recomendações de livros.
public class Exercicio3IOCaracter {
    public static void copiarArquivo() throws IOException {
        File f = new File("/home/cami/git/curso-dio-intro-java-io/recomendacoes.txt");
        String nameArquivo = f.getName();

        /*FileReader r = new FileReader(nameArquivo);
        BufferedReader br = new BufferedReader(r);*/
        BufferedReader br = new BufferedReader(new FileReader(nameArquivo)); // decorator BufferedReader para leitura de text
        String line = br.readLine();

        String nameArquivoCopy = nameArquivo.substring(0, nameArquivo.indexOf(".")).concat("-copy.txt");
        File fcopy = new File(nameArquivoCopy);

        BufferedWriter bw = new BufferedWriter(new FileWriter(fcopy.getName())); // decorator BufferedWriter para escrita de texto

        do{
            bw.write(line); // escrever no buffer
            bw.newLine(); // pular para proxima linha
            bw.flush(); // terminado o loop, enviar as informações capturadas pelo teclado no arquivo recomendacoes.txt
            line = br.readLine();
        }while(!(line == null));

        System.out.printf("Arquivo \"%s\" copiado com sucesso! Com o tamanho '%d' bytes.\n", f.getName(), f.length());
        System.out.printf("Arquivo \"%s\" criado com sucesso! Com o tamanho '%d' bytes.\n", fcopy.getName(), fcopy.length());

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recomende 3 livros: ");
        pw.flush(); // enviar o conteúdo do metodo write no console

        adicionarInfoNoArquivo(fcopy.getName());

        pw.printf("Ok! Tudo certo. Tamanho do arquivo '%d' bytes.", fcopy.length());

        br.close(); // fechamos o fluxo de entrada (liberar recursos)
        bw.close(); // fechamos o fluxo de saída (liberar recursos)
        pw.close(); // fechamos o fluxo de saída (liberar recursos)


    }

    public static void adicionarInfoNoArquivo(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));

        do{
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        }while(!(line.equalsIgnoreCase("fim")));

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        copiarArquivo();

    }
}
