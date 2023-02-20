import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Laberinto {

	public static void main(String[] args) throws IOException {

		// Scanner
		Scanner teclado = new Scanner(System.in);

		/*
		 * Son los niveles del laberinto
		 */

		// Nivel1
		char[][] laberintoNivel1 = { { ' ', ' ', '▒', '▒', '▒', '▒' }, 
									{ '▒', ' ', ' ', ' ', ' ', '▒' },
									{ '▒', ' ', '▒', '▒', '▒', '▒' }, 
									{ '▒', ' ', ' ', '▒', '▒', '▒' }, 
									{ '▒', '▒', ' ', ' ', ' ', '▒' },
									{ '▒', '▒', '▒', '▒', ' ', '▒' } };

		// Nivel2
		char[][] laberintoNivel2 = { { ' ', '▒', '▒', '▒', '▒', '▒', '▒', '▒' },
									{ ' ', ' ', ' ', ' ', ' ', ' ', ' ', '▒' }, 
									{ '▒', ' ', '▒', '▒', ' ', '▒', '▒', '▒' },
									{ '▒', ' ', ' ', '▒', '▒', '▒', ' ', '▒' }, 
									{ '▒', ' ', ' ', ' ', ' ', '▒', '▒', '▒' },
									{ '▒', '▒', '▒', '▒', ' ', ' ', ' ', '▒' }, 
									{ '▒', ' ', ' ', ' ', ' ', ' ', '▒', '▒' },
									{ '▒', '▒', '▒', '▒', '▒', ' ', '▒', '▒' } };

		// Nivel3
		char[][] laberintoNivel3 = { { ' ', ' ', '▒', '▒', '▒', '▒', '▒', '▒', '▒', '▒' },
									{ '▒', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '▒' },
									{ '▒', ' ', '▒', '▒', '▒', '▒', '▒', '▒', '▒', '▒' },
									{ '▒', ' ', ' ', '▒', ' ', ' ', ' ', ' ', ' ', '▒' },
									{ '▒', ' ', ' ', '▒', ' ', '▒', ' ', '▒', ' ', '▒' },
									{ '▒', '▒', ' ', '▒', ' ', ' ', ' ', '▒', ' ', '▒' },
									{ '▒', ' ', ' ', '▒', ' ', '▒', '▒', '▒', ' ', '▒' },
									{ '▒', ' ', '▒', '▒', ' ', ' ', ' ', ' ', ' ', '▒' },
									{ '▒', ' ', ' ', ' ', ' ', '▒', ' ', ' ', ' ', '▒' },
									{ '▒', '▒', '▒', '▒', '▒', '▒', ' ', '▒', '▒', '▒' } };
		
		/*
		 * MENU
		 */
		
		// Muestro el menu
		System.out.println("---------- MENÚ ----------");
		System.out.println("1-Jugar Partida\n2-Resultats partides\nq-Sortir\n");
		System.out.println("--------------------------");
		System.out.print("Elija una opción: ");
		String opcionMenu = teclado.next();
		
		switch (opcionMenu) {
		case "1":
			System.out.println("1-Fàcil\n2-Medio\n3-Difícil\n");
			System.out.println("--------------------------");
			System.out.print("Elija el nivel: ");
			int nivel = teclado.nextInt();
			System.out.print("Cuantas partidas quieres jugar???: ");
			int numPartidas = teclado.nextInt();
			System.out.println("-------------------------------------------------");
			System.out.println("| Usa las teclas w(↑),s(↓),a(←),d(→) para mover |");
			System.out.println("-------------------------------------------------");
			for (int i = 0; i < numPartidas; i++) {
				if (nivel == 1) {
					// Posición de Pepito
					laberintoNivel1[0][0] = '☺';
					// Posición de corazón
					laberintoNivel1[5][4] = '♥';

					// Fila y columna de pepito
					int N1filP = 0;
					int N1colP = 0;
					// Fila y columna de corazon
					int N1filC = 5;
					int N1colC = 4;
					System.out.println("Partida " + (i + 1));
					moverPepito(laberintoNivel1, N1filP, N1colP, N1filC, N1colC, nivel, numPartidas);
				} else if (nivel == 2) {
					// Posición de Pepito
					laberintoNivel2[0][0] = '☺';
					// Posición de corazón
					laberintoNivel2[7][5] = '♥';

					// Fila y columna de pepito
					int N2filP = 0;
					int N2colP = 0;
					// Fila y columna de corazon
					int N2filC = 7;
					int N2colC = 5;
					System.out.println("Partida " + (i + 1));
					moverPepito(laberintoNivel2, N2filP, N2colP, N2filC, N2colC, nivel, numPartidas);
				} else if (nivel == 3) {
					// Posición de Pepito
					laberintoNivel3[0][0] = '☺';
					// Posición de corazón
					laberintoNivel3[9][6] = '♥';

					// Fila y columna de pepito
					int N3filP = 0;
					int N3colP = 0;
					// Fila y columna de corazon
					int N3filC = 9;
					int N3colC = 6;
					System.out.println("Partida " + (i + 1));
					moverPepito(laberintoNivel3, N3filP, N3colP, N3filC, N3colC, nivel, numPartidas);
				} else {
					System.out.println("!Error!, no exixte el nivell que intentas jugar...");
				}
			}
			break;
		case "2":
			System.out.println("--------------------------");
			System.out.println("|   RESULTADOS PARTIDAS  |");
			System.out.println("--------------------------");
			mostrarResultado();
			break;
		case "q":
			System.out.println("Has salido del menú...");
			break;
		default:
			System.out.println("Opción no valida, volver a cargar el menú...");
			break;
		}

	}

	/**
	 * Función que imprime la mapa del laberinto y recorre las filas y columnas
	 *
	 * @param mapa le pasamos una matriz como el parametro
	 */
	public static void mapaLaberinto(char[][] mapa) {

		// Recorremos la filas y las columnas
		for (int fil = 0; fil < mapa.length; fil++) {
			for (int col = 0; col < mapa.length; col++) {

				if (mapa[fil][col] == '▒') {

				} else if (mapa[fil][col] == ' ') {
				}

				// Imprimimos la mapa
				System.out.print(mapa[fil][col]);

			}
			// Salto de linia
			System.out.println();
		}
	}

	/**
	 * Funicón que mueve el pepito segun tecla presionada
	 *
	 * @param laberinto
	 * @param nivel
	 * @throws IOException
	 */
	public static void moverPepito(char[][] laberinto, int fil, int col, int filC, int colC, int nivel, int partida)
			throws IOException {
		// Scanner
		Scanner teclado = new Scanner(System.in);

		boolean salir = true;

		// Contador de vidas
		int golpes = 0;

		// Los golpes mientras que sean menor que 5
		while (golpes < 3) {

			if (laberinto[fil][col] != laberinto[filC][colC]) {

				// Laberinto
				mapaLaberinto(laberinto);

				// mover
				String tecla = move();

				// Arriba
				if (tecla.equalsIgnoreCase("w")) {
					if (fil - 1 >= 0 && laberinto[fil - 1][col] != '▒') {
						laberinto[fil - 1][col] = '☺';
						laberinto[fil][col] = ' ';
						fil--;
					} else {
						golpes++;
						System.out.println("Has golpeado " + golpes + ", te quedan " + (3 - golpes));
					}
				}

				// Abajo
				if (tecla.equalsIgnoreCase("s")) {
					if (fil + 1 < laberinto.length && laberinto[fil + 1][col] != '▒') {
						laberinto[fil + 1][col] = '☺';
						laberinto[fil][col] = ' ';
						fil++;
					} else {
						golpes++;
						System.out.println("Has golpeado " + golpes + ", te quedan " + (3 - golpes));
					}
				}

				// Izquierda
				if (tecla.equalsIgnoreCase("a")) {
					if (col - 1 >= 0 && laberinto[fil][col - 1] != '▒') {
						laberinto[fil][col - 1] = '☺';
						laberinto[fil][col] = ' ';
						col--;
					} else {
						golpes++;
						System.out.println("Has golpeado " + golpes + ", te quedan " + (3 - golpes));
					}
				}

				// Derecha
				if (tecla.equalsIgnoreCase("d")) {
					if (col + 1 < laberinto[0].length && laberinto[fil][col + 1] != '▒') {
						laberinto[fil][col + 1] = '☺';
						laberinto[fil][col] = ' ';
						col++;
					} else {
						golpes++;
						System.out.println("Has golpeado " + golpes + ", te quedan " + (3 - golpes));
					}
				}
				if (golpes == 3) {
					System.out.println("Has perdido la partida.");
					guardarResultado(false, nivel, partida);
				}

				// Salir
				if (tecla.equalsIgnoreCase("q")) {
					System.out.println("Has salido del juego!");
					salir = true;
					golpes = 3;
					guardarResultado(false, nivel, partida);
				}

			} else {
				System.out.println("Has ganado la partida!");
				guardarResultado(true, nivel, partida);
				golpes = 3;

			}

		}
	}

	/**
	 * Función que pide las tecla para mover
	 *
	 * @return la tecla
	 */
	public static String move() {
		Scanner teclado = new Scanner(System.in);

		int pasos = 0;

		System.out.print("Mover ->");
		String tecla = teclado.next();
		pasos++;
		return tecla;
	}

	/**
	 * Función que guarda los resultados del partido
	 * 
	 * @throws IOException
	 */
	public static void guardarResultado(boolean haGanado, int nivel, int partidas) throws IOException {
		String file = "nombreFichero.txt";
		String escribir = "";
		FileReader fichero = new FileReader(file);
		Scanner teclado = new Scanner(fichero);
		while (teclado.hasNextLine()) {
			escribir += teclado.nextLine() + "\n";
		}
		if (haGanado) {
			escribir += ("Ha completado el nivel " + nivel + " y ha gando!");
		} else {
			escribir += ("No ha completado el nivel " + nivel);
		}

		FileWriter fw = new FileWriter(file);
		fw.write(escribir);
		fw.flush();
	}

	/**
	 * Función que muestra los resultados del partido
	 * 
	 * @throws FileNotFoundException
	 */
	public static void mostrarResultado() throws FileNotFoundException {
		String file = "nombreFichero.txt";
		FileReader fichero = new FileReader(file);
		Scanner teclado = new Scanner(fichero);
		while (teclado.hasNextLine()) {
			System.out.println(teclado.nextLine());
		}
	}

}
