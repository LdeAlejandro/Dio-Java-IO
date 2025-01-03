package br.com.dio.java.io.IOCharacter;

import java.io.*;
import java.util.Scanner;

//Abra o teclado para escrever 3 filmes que você recomendaria e armazene em “recomendacoes.txt”.
public class Exercicio2IOCaracter {

    public static void lerTecladoEscreverDocumento() throws IOException {

        PrintWriter pw = new PrintWriter(System.out); // impressão no console
        pw.println("Digite 3 recomendações de filmes: ");
        pw.flush(); // enviar o conteúdo do metodo write no console

        Scanner scan = new Scanner(System.in); // instanciando scan para capturar entrada
        String line = scan.nextLine(); // capturar linha

        File f = new File("recomendacoes.txt"); // criar arquivo recomendacoes.txt

        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName())); //  buffer que permite armazenar nome do arquivo e escrever no mesmo

        do {
            bw.write(line); // escrever no buffer interno a linha capturada pelo scanner
            bw.newLine(); // pular para proxima linha no buffer
            bw.flush(); // terminado o loop, enviar as informações capturadas pelo teclado no arquivo recomendacoes.txt
            line = scan.nextLine(); // pegar a proxima linha
        } while(!(line.equalsIgnoreCase("fim")));

        pw.printf("Arquivo \"%s\" foi criado com sucesso!", f.getName());
        //pw.flush();

        pw.close(); // fechar o fluxo de saída (liberar recursos)
        scan.close(); // fechar o fluxo de entrada (liberar recursos)
        bw.close(); // fechar o fluxo de saída (liberar recursos)

    }

    public static void main(String[] args) throws IOException {
        lerTecladoEscreverDocumento();
    }

}
