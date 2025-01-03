package br.com.dio.java.io.IOBytes;

import java.io.*;

//Faça uma cópia do arquivo “recomendacoes-copy.txt”.
public class ExemploIOBytes {
    public static void copiarArquivo() throws IOException {
      File f = new File("/home/cami/git/curso-dio-intro-java-io/recomendacoes-copy.txt");
      String nomeArquivo = f.getName();

     BufferedInputStream bis = new BufferedInputStream(new FileInputStream(nomeArquivo)); // padrão decorator para leitura de arquivos

        String nomeArquivoCopy = nomeArquivo.substring(0, nomeArquivo.indexOf("-")).concat("-copy2.txt"); // substring extrai o nome do arquivo antes do "-" e concatena com "-copy2.txt"
        File fCopy = new File(nomeArquivoCopy); // cria uma referência para o arquivo copia

        //
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fCopy)); // padrão decorator para escrita de arquivos

        int line = 0;
        while((line = bis.read()) != -1){ // enquanto houver linhas para serem lidas

            bos.write((char) line); // escreve no arquivo copia a linha lida do arquivo original char por char
            bos.flush(); // limpa o buffer

        }
        bis.close(); // fechando fluxo
        bos.close(); // fechando fluxo

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo \"%s\" copiado com sucesso e esta no diretório %s com %d bytes.", fCopy.getName(), fCopy.getPath(), fCopy.length());
    }

    public static void main(String[] args) throws IOException {
        copiarArquivo();
    }
}
