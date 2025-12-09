import com.sun.source.tree.ReturnTree;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Workshop {
    public static void main(String[] args) {

    }

    // Suma de dos enteros
    public int sumarDosNumeros(int a, int b) {
        return a+b; //Aqui no se requieren cambios, pues el return ya suma los dos numeros dados
    }

    // Mayor de tres numeros
    public int mayorDeTresNumeros(int a, int b, int c) {
        return Math.max(a, Math.max(b, c)); //Math.max y Math.min devuelven el mayor o menor entre dos numeros dados respectivamente. En este caso, se anidan dos Math.max: el primero compara b y c, el segundo compara el resultado con a
    }

    // Tabla de multiplicar
    public int[] tablaMultiplicar(int numero, int limite) {
        int[] respuesta = new int[limite];
        for (int i=1; i<= limite; i++) {
            respuesta[i-1] = i * numero; //Se complicó mas de la cuenta porque pase por alto el hecho de que los arreglos inician desde 0 (por defecto)
        }
        return respuesta;
    }

    // Factorial
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Los negativos no poseen factorial");
        }
        // Inicializar el resultado con 1 (ya que 0! = 1!)
        int resultado = 1;
        // Multiplicar el resultado por i desde 2 hasta N
        for (int i = 2; i <= n; i++) {
            // Multiplicar el resultado actual por el número i
            resultado = resultado*i;
        }
        return resultado;
    }

    // Numero Primo
    public boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false; //0 y 1 no se consideran primos
        }
        if (numero <= 3) {
            return true; // 2 y 3 son primos
        }

        // 2. Descartar múltiplos de 2 y 3
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= numero; i = i + 6) {//se usa el que todos los divisores de un numero no primo se encuentran entre 2 y la raiz del numero
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Fibonacci
    public int[] serieFibonacci(int n) {
        if (n <= 0) {
            return new int[0]; // Devuelve un array vacío si N es 0 o negativo
        }
        int[] serie = new int[n];
        if (n >= 1) {
            serie[0] = 0; // F(0)
        }
        if (n >= 2) {
            serie[1] = 1; // F(1)
        }
        for (int i = 2; i < n; i++) {
            serie[i] = serie[i - 1] + serie[i - 2];
        }
        return serie;
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
        return res >= 0;
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

    // Eliminar duplicados
    public int[] eliminarDuplicados(int[] arreglo) {
        return Arrays.stream(arreglo) //se covierte el arreglo en un ArrayStream
                .distinct()//distinct permite hacer la verificacion de elementos repetidos
                .toArray();// se revierte a un Array el resultado, que son los elementos unicos en su orden inicial
    }

    // Combinacion de arreglos
    public int[] combinarArreglos(int[] arreglo1, int[] arreglo2) {
        return IntStream.concat(Arrays.stream(arreglo1), Arrays.stream(arreglo2)) //usando la funcion concat perteneciente a Array Stream, se concatenan los arreglos
                .toArray();
    }

    // Rotacion de arreglos
    public int[] rotarArreglo(int[] arreglo, int posiciones) {
        int n = arreglo.length;
        if (n <= 1) {//para cuando el arreglo tiene un elemento o menos
            return arreglo;
        }
        int k = posiciones % n;
        if (k < 0) { //se calcula el desplazamiento real de los elementos hacia la derecha
            k = n + k;
        }
        int[] resultado = new int[n];
        System.arraycopy(arreglo, n - k, resultado, 0, k);
        System.arraycopy(arreglo, 0, resultado, k, n - k);
        return resultado;
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

    //Palindromo
    public boolean esPalindromo(String cadena) {
        boolean palindromo=false;
        String limpieza = cadena.toLowerCase() //Convierte a minuscula todos los caracteres
                .replaceAll("\\p{Mn}", "") // Remplaza acentos por espacios vacios
                .replaceAll("[^a-z0-9]", ""); // Elimina caracteres no alfanuméricos
            String invertido = new StringBuilder(limpieza)//StringBuilder es una clase la cual permite modificar mas eficientemente las cadenas de texto
                    .reverse()//invierte el Stringbuilder
                    .toString();// revierte el Stringbuilder a string
            if (limpieza.equals(invertido)){ // compara ambas cadenas como ==
                palindromo=true;
            }
        return palindromo;
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
        return cadena.indexOf(subcadena);
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

    public String pptls2(String[] game) {
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

    //Zodiaco
    public String zoodiac(int day, int month) {
        String signo ="";
        if (month==1){
            if (day>=1 & day<=19){
                signo="Capricornio";
            }
            else if (day>=20 & day<=31){
                signo="Acuario";
            }
            else{
                signo="Invalid Date";
            }
        }
        else if (month==2){
            if (day>=1 & day<=18){
                signo="Acuario";
            }
            else if (day>=19 & day<=29){
                signo="Picsis";
            }
            else{
                signo="Invalid Date";
            }
        }
        else if (month==3){
            if (day>=1 & day<=20){
                signo="Picsis";;
            }
            else if (day>=21 & day<=30){
                signo="Aries";
            }
            else{
                signo="Invalid Date";
            }
        }
        else if (month==4){
            if (day>=1 & day<=19){
                signo="Aries";
            }
            else if (day>=20 & day<=31){
                signo="Tauro";
            }
            else{
                signo="Invalid Date";
            }
        }
        else if (month==5){
            if (day>=1 & day<=20){
                signo="Tauro";
            }
            else if (day>=21 & day<=30){
                signo="Geminis";
            }
            else{
                signo="Invalid Date";
            }
        }
        else if (month==6){
            if (day>=1 & day<=20){
                signo="Geminis";
            }
            else if (day>=21 & day<=31){
                signo="Cancer";
            }
            else{
                signo="Invalid Date";
            }
        }
        else if (month==7){
            if (day>=1 & day<=22){
                signo="Cancer";
            }
            else if (day>=23 & day<=30){
                signo="Leo";
            }
            else{
                signo="Invalid Date";
            }
        }
        else if (month==8){
            if (day>=1 & day<=22){
                signo="Leo";
            }
            else if (day>=23 & day<31){
                signo="Virgo";
            }
            else{
                signo="Invalid Date";
            }
        }
        else if (month==9){
            if (day>=1 & day<=22){
                signo="Virgo";
            }
            else if (day>=23 & day<30){
                signo="Libra";
            }
            else{
                signo="Invalid Date";
            }
        }
        else if (month==10){
            if (day>=1 & day<=22){
                signo="Libra";
            }
            else if (day>=23 & day<=31){
                signo="Escorpio";
            }
            else{
                signo="Invalid Date";
            }
        }
        else if (month==11){
            if (day>=1 & day<21){
                signo="Escorpio";
            }
            else if (day>=22 & day<=30){
                signo="Sagitario";
            }
            else{
                signo="Invalid Date";
            }
        }
        else if (month==12){
            if (day>=1 & day<=21){
                signo="Sagitario";
            }
            else if (day>=22 & day<=31){
                signo="Capricornio";
            }
            else{
                signo="Invalid Date";
            }
        }
        else{
            signo="Invalid Date";
        }
        return signo;
    }
}

