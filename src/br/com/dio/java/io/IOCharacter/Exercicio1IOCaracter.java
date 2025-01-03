package br.com.dio.java.io.IOCharacter;


import java.io.*;

//Abra o teclado para escrever 3 filmes que você recomendaria e exiba esses filmes no console.
public class Exercicio1IOCaracter {
    public static void receberTecladoImprimirConsole() throws IOException {

        /*InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);*/
        System.out.println("Recomende 3 filmes: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // decorator para leitura do teclado
        String line = br.readLine();

        /*OutputStream os = System.out;
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);*/
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // decorator para escrita no console

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while(!(line.isEmpty()));
        bw.flush(); // terminado o loop, enviar as informações capturadas pelo teclado no console

        br.close(); // fechamos o fluxo de entrada (liberar recursos)
        bw.close(); // fechamos o fluxo de saída (liberar recursos)

    }

    public static void main(String[] args) throws IOException {
        receberTecladoImprimirConsole();
    }

}
