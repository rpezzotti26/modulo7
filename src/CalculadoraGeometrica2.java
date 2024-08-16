import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class CalculadoraGeometrica2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> resultados = new ArrayList<>();

        while (true) {
            try {
                System.out.println("Seleccione la figura geométrica:");
                System.out.println("1. Círculo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Triángulo");
                System.out.println("4. Rectángulo");
                System.out.println("5. Pentágono");
                System.out.println("6. Ver resultados");
                System.out.println("7. Salir");
                int opcionFigura = scanner.nextInt();

                if (opcionFigura == 7) {
                    System.out.println("¡Adiós!");
                    break;
                } else if (opcionFigura == 6) {
                    mostrarResultados(resultados);
                    continue;
                }

                System.out.println("Seleccione la operación:");
                System.out.println("1. Calcular área");
                System.out.println("2. Calcular perímetro");
                int opcionOperacion = scanner.nextInt();

                double resultado = 0;
                switch (opcionFigura) {
                    case 1: // Círculo
                        System.out.print("Ingrese el radio del círculo: ");
                        double radio = scanner.nextDouble();
                        resultado = (opcionOperacion == 1) ? Math.PI * Math.pow(radio, 2) : 2 * Math.PI * radio;
                        break;
                    case 2: // Cuadrado
                        System.out.print("Ingrese el lado del cuadrado: ");
                        double lado = scanner.nextDouble();
                        resultado = (opcionOperacion == 1) ? Math.pow(lado, 2) : 4 * lado;
                        break;
                    case 3: // Triángulo
                        System.out.print("Ingrese la base del triángulo: ");
                        double base = scanner.nextDouble();
                        System.out.print("Ingrese la altura del triángulo: ");
                        double altura = scanner.nextDouble();
                        if (opcionOperacion == 1) {
                            resultado = (base * altura) / 2;
                        } else {
                            System.out.print("Ingrese los otros dos lados del triángulo (separados por espacio): ");
                            double lado2 = scanner.nextDouble();
                            double lado3 = scanner.nextDouble();
                            resultado = base + lado2 + lado3;
                        }
                        break;
                    case 4: // Rectángulo
                        System.out.print("Ingrese la longitud del rectángulo: ");
                        double longitud = scanner.nextDouble();
                        System.out.print("Ingrese el ancho del rectángulo: ");
                        double ancho = scanner.nextDouble();
                        resultado = (opcionOperacion == 1) ? longitud * ancho : 2 * (longitud + ancho);
                        break;
                    case 5: // Pentágono
                        System.out.print("Ingrese el lado del pentágono: ");
                        double ladoPentagono = scanner.nextDouble();
                        System.out.print("Ingrese el apotema del pentágono: ");
                        double apotema = scanner.nextDouble();
                        resultado = (opcionOperacion == 1) ? (5 * ladoPentagono * apotema) / 2 : 5 * ladoPentagono;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        continue;
                }
                resultados.add(resultado);
                System.out.println("El resultado es: " + resultado);
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer
            }
        }
        scanner.close();
    }

    private static void mostrarResultados(ArrayList<Double> resultados) {
        System.out.println("Resultados almacenados:");
        if (resultados.isEmpty()) {
            System.out.println("No hay resultados almacenados.");
        } else {
            for (int i = 0; i < resultados.size(); i++) {
                System.out.println((i + 1) + ". " + resultados.get(i));
            }
        }
    }
}
