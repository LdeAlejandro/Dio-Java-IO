

```java 
OutputStream os = new FileOutputStream(file);
BufferedOutputStream bos = new BufferedOutputStream(os);

FileOutputStream (para escribir en archivos).
ByteArrayOutputStream (para escribir en memoria).
SocketOutputStream (para enviar datos a través de sockets).

DataOutputStream (int, float, char).
```

- **FileOutputStream**: Para escrever em arquivos.
- **ByteArrayOutputStream**: Para escrever na memória.
- **SocketOutputStream**: Para enviar dados através de sockets.
- **BufferedOutputStream**: Para melhorar o desempenho da escrita com buffers.
- **DataOutputStream**: Para gravar dados primitivos de maneira portátil (int, float, char, etc.).


## Tipos de `OutputStream`:

### 1. **FileOutputStream**
   - **Descrição**: Usado para escrever dados em arquivos no sistema de arquivos.
   - **Uso**: Você pode usá-lo para gravar bytes em um arquivo.
   - **Exemplo**:
     ```java
     FileOutputStream os = new FileOutputStream("arquivo.txt");
     os.write("Texto de exemplo".getBytes());
     os.close();
     ```
   - **Quando usar**: Quando você precisar gravar dados em arquivos físicos.

### 2. **ByteArrayOutputStream**
   - **Descrição**: Escreve os dados em um array de bytes na memória. Ideal quando você precisa manipular os dados antes de gravá-los em um arquivo ou enviá-los.
   - **Uso**: Escreve dados na memória e pode ser convertido para um array de bytes usando o método `toByteArray()`.
   - **Exemplo**:
     ```java
     ByteArrayOutputStream baos = new ByteArrayOutputStream();
     baos.write("Texto de exemplo".getBytes());
     byte[] dados = baos.toByteArray();
     ```
   - **Quando usar**: Quando você precisa armazenar os dados na memória antes de usar ou transferir.

### 3. **SocketOutputStream**
   - **Descrição**: Envia dados por meio de um socket. Usado em comunicações de rede para enviar dados entre clientes e servidores.
   - **Uso**: Geralmente usado em conjunto com um `Socket` para enviar dados por uma conexão de rede.
   - **Exemplo**:
     ```java
     Socket socket = new Socket("localhost", 8080);
     OutputStream os = socket.getOutputStream();
     os.write("Mensagem para o servidor".getBytes());
     os.close();
     socket.close();
     ```
   - **Quando usar**: Quando você precisa enviar dados para outra máquina através de uma rede, como em conexões TCP/IP.

### 4. **BufferedOutputStream**
   - **Descrição**: Usado para melhorar o desempenho ao escrever em um stream, como arquivos ou sockets. Ele usa um buffer interno para reduzir o número de operações de I/O.
   - **Uso**: Combina um `OutputStream` com um buffer para melhorar o desempenho ao gravar dados.
   - **Exemplo**:
     ```java
     FileOutputStream os = new FileOutputStream("arquivo.txt");
     BufferedOutputStream bos = new BufferedOutputStream(os);
     bos.write("Texto de exemplo".getBytes());
     bos.close();
     os.close();
     ```
   - **Quando usar**: Quando você precisa otimizar a gravação de grandes volumes de dados, reduzindo a quantidade de operações de I/O.

### 5. **DataOutputStream**
   - **Descrição**: Permite escrever dados primitivos (como `int`, `float`, `char`) de maneira portátil, isto é, os dados são escritos de forma que podem ser lidos em qualquer plataforma de maneira consistente.
   - **Uso**: Ideal para gravar dados binários como números inteiros, flutuantes, caracteres, etc.
   - **Exemplo**:
     ```java
     DataOutputStream dos = new DataOutputStream(new FileOutputStream("dados.dat"));
     dos.writeInt(42);
     dos.writeFloat(3.14f);
     dos.writeChar('A');
     dos.close();
     ```
   - **Quando usar**: Quando você precisar gravar dados primitivos de maneira portátil para leitura posterior, como em sistemas de banco de dados ou formatos binários.

---



