import java.util.Arrays;
import java.util.List;

public class Workshop {
    public static void main(String[] args) {

    }

    // Suma de dos enteros
    public int sumarDosNumeros(int a, int b) {
        return a+b; //Aqui no se requieren cambios, pues el return ya suma los dos numeros dados
    }

    // Mayor de tres numeros
    public int mayorDeTresNumeros(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c)); //Math.max y Math.min devuelven el mayor o menor entre dos numeros dados respectivamente. En este caso, se anidan dos Math.max: el primero compara b y c, el segundo compara el resultado con a
        return max;
    }

    // Tabla de multiplicar
    public int[] tablaMultiplicar(int numero, int limite) {
        int respuesta[] = new int[limite];
        for (int i=1; i<= limite; i++) {
            respuesta[i-1] = i * numero; //Se complico mas de la cuenta porque pase por alto el hecho de que los arreglos inician desde 0 (por defecto)
        }
        return respuesta;
    }

    // Método que calcula el factorial de un número entero
    public int factorial(int n) {
        // TODO: Implementar el método para calcular el factorial de un número entero.
        // Ejemplo: Si n = 5, el resultado debería ser 120.
        // Lanzar IllegalArgumentException si n es negativo.
        return 0;
    }

    // Método que verifica si un número es primo
    public boolean esPrimo(int numero) {
        // TODO: Implementar el método para verificar si un número es primo.
        // Ejemplo: Si numero = 7, el resultado debería ser true.
        return false;
    }

    // Método que genera una serie de Fibonacci
    public int[] serieFibonacci(int n) {
        // TODO: Implementar el método para generar la serie de Fibonacci hasta el número n.
        // Ejemplo: Si n = 5, el resultado debería ser [0, 1, 1, 2, 3].
        // Lanzar IllegalArgumentException si n es negativo.
        return new int[0];
    }

    //Suma de elementos de un arreglo
    public int sumaElementos(int[] arreglo) {
        return Arrays.stream(arreglo).sum(); // Convierte el array a un IntStream para luego sumar todos los elementos con sum().sum();
    }

    // Promedio de un arreglo
    public double promedioElementos(int[] arreglo) {
        return Arrays.stream(arreglo).average().orElse(0.0);//se convierte de nuevo a IntStream y usando .average se obtiene un promedio. Como .average devuelve un tipo de dato llamado OptionalDouble se requiere .orElse para manejar cuando el promedio va vacio (como un if)
    }

    // Valor mayor de un arreglo
    public int encontrarElementoMayor(int[] arreglo) {
        return Arrays.stream(arreglo).max().orElse(0);//se convierte de nuevo a IntStream y usando .max se obtiene el valor mayor. Igual que .average devuelve un dato opcional: optional.Int eso requiere un orElse (otra vez)
    }

    // Valor menor de un arreglo
    public int encontrarElementoMenor(int[] arreglo) {
        return Arrays.stream(arreglo).min().orElse(0);//misma logica que el anterior, pero con .min esta vez
    }

    // Busqueda de elemento
    public boolean buscarElemento(int[] arreglo, int elemento) {
        Arrays.sort(arreglo);
        int res= Arrays.binarySearch(arreglo, elemento);//con binarySearch se ubica el indice del elemento, si exsite se, devuelve; si no, da un negativo
        if (res>=0){// el valor de respuesta se trasforma en un bool con un if
            return true;
        }
        else {
            return false;
        }
    }

    // Inversion de un arreglo
    public int[] invertirArreglo(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n / 2; i++) {
            int j = n - 1 - i;
            int temp = arreglo[i];
            arreglo[i] = arreglo[j];
            arreglo[j] = temp;
        }
        return arreglo;
    }

    // Arreglo ascendente
    public int[] ordenarArreglo(int[] arreglo) {
        Arrays.sort(arreglo); //sort no devuelve nada, solo organiza
        return arreglo;
    }

    // Método que elimina los duplicados de un arreglo
    public int[] eliminarDuplicados(int[] arreglo) {
        // TODO: Implementar el método para eliminar los duplicados de un arreglo.
        // Ejemplo: Si arreglo = [1, 2, 2, 3, 4, 4, 5], el resultado debería ser [1, 2, 3, 4, 5].
        return new int[0];
    }

    // Método que combina dos arreglos en uno solo
    public int[] combinarArreglos(int[] arreglo1, int[] arreglo2) {
        // TODO: Implementar el método para combinar dos arreglos en uno solo.
        // Ejemplo: Si arreglo1 = [1, 2, 3, 4, 5] y arreglo2 = [6, 7, 8], el resultado debería ser [1, 2, 3, 4, 5, 6, 7, 8].
        return new int[0];
    }

    // Método que rota un arreglo n posiciones
    public int[] rotarArreglo(int[] arreglo, int posiciones) {
        // TODO: Implementar el método para rotar un arreglo n posiciones.
        // Ejemplo: Si arreglo = [1, 2, 3, 4, 5] y posiciones = 2, el resultado debería ser [3, 4, 5, 1, 2].
        return new int[0];
    }

    //Contar caracteres
    public int contarCaracteres(String cadena) {
        StringBuilder string= new StringBuilder(cadena);//Se usa Stringbuilder para poder manipular la cadena
        return string.length();//Length devuelve el numero de caracteres que posee un stringbuilder
    }

    // invertir cadena
    public String invertirCadena(String cadena) {
        StringBuilder string=new StringBuilder(cadena)
                .reverse();
        return string.toString();
    }

    // Método que verifica si una cadena es un palíndromo
    public boolean esPalindromo(String cadena) {
        // TODO: Implementar el método para verificar si una cadena es un palíndromo.
        // Ejemplo: Si cadena = "madam", el resultado debería ser true.
        return false;
    }

    // Contar palabras
    public int contarPalabras(String cadena) {
        cadena=cadena.trim();//deshacerce de los espacios al inicio y final
        if (cadena.isEmpty())
        {
            return 0;
        }
        String[] palabras = cadena.split("\\s+");//se arma un arreglo con las palabras separadas en los espacios. \\s+ es el codigo que indica los espacios y slit busca y corta ahi
        return palabras.length;//se devuelve la longitud del arreglo armado
    }

    //A mayusculas
    public String convertirAMayusculas(String cadena) {
        cadena=cadena.toUpperCase();
        return cadena;
    }

    //A minusculas
    public String convertirAMinusculas(String cadena) {
        cadena=cadena.toLowerCase();
        return cadena;
    }

    //Reemplzar subcadena
    public String reemplazarSubcadena(String cadena, String antiguaSubcadena, String nuevaSubcadena) {
        cadena=cadena.replace(antiguaSubcadena, nuevaSubcadena);//parece que replace hace el trabajo solo
        return cadena;
    }

    // Posicion subcadena
    public int buscarSubcadena(String cadena, String subcadena) {
        int posicion = cadena.indexOf(subcadena);
        return posicion;
    }

    // Método que valida un correo electrónico
    public boolean validarCorreoElectronico(String correo) {
        // TODO: Implementar el método para validar un correo electrónico.
        // Ejemplo: Si correo = "test@example.com", el resultado debería ser true.
        return false;
    }

    // Método que calcula el promedio de una lista de números

    public double promedioLista(List<Integer> lista) {
        // TODO: Implementar el método para calcular el promedio de una lista de números.
        // Ejemplo: Si lista = [1, 2, 3, 4, 5], el resultado debería ser 3.0.
        return 0.0;
    }

    // Método que convierte un número en su representación binaria
    public String convertirABinario(int numero) {
        // TODO: Implementar el método para convertir un número en su representación binaria.
        // Ejemplo: Si numero = 10, el resultado debería ser "1010".
        return "";
    }

    // Método que convierte un número en su representación hexadecimal
    public String convertirAHexadecimal(int numero) {
        // TODO: Implementar el método para convertir un número en su representación hexadecimal.
        // Ejemplo: Si numero = 255, el resultado debería ser "FF".
        return "";
    }

    // Método para el juego de piedra, papel, tijera, lagarto, Spock
    public String jugarPiedraPapelTijeraLagartoSpock(String eleccionUsuario) {
        // TODO: Implementar el método para el juego de Piedra, Papel, Tijera, Lagarto, Spock.
        // Las reglas del juego son:
        // - Piedra vence a Tijera y Lagarto
        // - Papel vence a Piedra y Spock
        // - Tijera vence a Papel y Lagarto
        // - Lagarto vence a Spock y Papel
        // - Spock vence a Tijera y Piedra


        // El método debe retornar un mensaje indicando el resultado del juego.
        // Ejemplo: Si la eleccionUsuario es "Piedra", el resultado podría ser "Ganaste" o "Perdiste" dependiendo de la elección de la computadora.
        return "";
    }

    public String pptls2(String game[]) {
        //Retornar player ganador o empate
            /*
            Rock = R
            Paper = P
            Scissors = S
            Lizard = L
            Spock = V
        Scissors cuts Paper
Paper covers Rock
Rock crushes Lizard
Lizard poisons Spock
Spock smashes Scissors
Scissors decapitates Lizard
Lizard eats Paper
Paper disproves Spock
Spock vaporizes Rock
Rock crushes Scissors
         */
        return "";
    }
    //Area circulo
    public double areaCirculo(double radio) {
        return (Math.PI*Math.pow(radio,2));
    }

    public String zoodiac(int day, int month) {
        return "";
    }


}

