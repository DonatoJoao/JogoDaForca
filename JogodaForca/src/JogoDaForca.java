import java.util.Scanner;

public class JogoDaForca {
    private static final String[] PALAVRAS = {"BANANA", "LARANJA", "MORANGO", "ABACAXI", "UVA", "MELANCIA", "PERA", "GOIABA", "MANGA"};
    private String palavra;
    private char[] letrasDescobertas;
    private int tentativasRestantes;
    private boolean jogoTerminou;

    public JogoDaForca() {
        palavra = selecionarPalavraAleatoria();
        letrasDescobertas = new char[palavra.length()];
        tentativasRestantes = 6;
        jogoTerminou = false;
        for (int i = 0; i < letrasDescobertas.length; i++) {
            letrasDescobertas[i] = '_';
        }
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        while (!jogoTerminou) {
            exibirForca();
            System.out.print("Digite uma letra: ");
            char letra = scanner.next().toUpperCase().charAt(0);
            if (!tentarLetra(letra)) {
                tentativasRestantes--;
                System.out.println("Letra incorreta! Tentativas restantes: " + tentativasRestantes);
            }
            if (tentativasRestantes == 0 || palavraCompleta()) {
                jogoTerminou = true;
            }
        }

        if (palavraCompleta()) {
            System.out.println("Parabéns! Você venceu! A Palavra era: " + palavra);
        } else {
            System.out.println("Você perdeu! A palavra era: " + palavra);
        }
    }

    private String selecionarPalavraAleatoria() {
        int indiceAleatorio = (int) (Math.random() * PALAVRAS.length);
        return PALAVRAS[indiceAleatorio];
    }

    private void exibirForca() {
        System.out.println();
        System.out.println("Palavra: " + String.valueOf(letrasDescobertas));
        System.out.println("Tentativas restantes: " + tentativasRestantes);
    }

    private boolean tentarLetra(char letra) {
        boolean encontrouLetra = false;
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                letrasDescobertas[i] = letra;
                encontrouLetra = true;
            }
        }
        return encontrouLetra;
    }

    private boolean palavraCompleta() {
        for (char letra : letrasDescobertas) {
            if (letra == '_') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Jogo da Forca!");
        JogoDaForca jogo = new JogoDaForca();
        jogo.jogar();
    }
}
