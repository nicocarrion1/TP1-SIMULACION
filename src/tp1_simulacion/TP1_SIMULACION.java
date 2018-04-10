/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_simulacion;
import java.util.InputMismatchException;
import java.util.Scanner; 

public class TP1_SIMULACION {
    private static boolean esPrimo(int n)
     {
         boolean res = true;
         for (int i = 3; i <= Math.sqrt(n); i++) {
             if (n%i == 0) {res = false;}
                        
         }
         if(n%2==0){res=false;}    
       if(n==1 || n ==2){res=true;}
         return res;
     } 
    public static double[] generadorMCMu(int x00, int aa, int modd, int n){
        Scanner sc = new Scanner(System.in);
        double x11 = (aa * x00) % modd;
        //System.out.println("xi+1 = " + x1);
        double[] vector;
        vector = new double [n];
        double rr; 
        rr = x11 /(modd);//se saca el menos uno para que no incluya el 1 
        System.out.println("Los 20 valores aleatorios son: ");
        System.out.println(String.format("%.4f", rr));
        vector[0]= rr; 
        for (int i = 1 ; i <n ; i++) {

            x11 = (aa * x11) % modd;
     
            //System.out.println("xi+1= " + x1);
            rr = x11 /(modd); // se saca el menos uno para que no incluya el 1
            //System.out.println("r= ");
            System.out.println(String.format("%.4f", rr));
            vector[i]= rr; 
        }
        
        
        return vector;
    }
    
    public static double chiCuadr(double[] v, int k)
    {
        //tamaño del intervalo
        double t;
        t = 1/(double)k;
        //distribucion de frecuencias
        double[] distribucion;
        distribucion = new double[k];
        //frecuencia esperada
        double fe = v.length/k;
        
        
        for (int i = 0; i < v.length; i++) {
            int vuelta = 0;
            for (double j = t; Math.round(j*100) <= 100; j+=t) {
                vuelta+=1;
                if (v[i]<j){
                    distribucion[vuelta-1]+=1;
                    break;
                }
                
            }
        }
        int vuelta=0;
        System.out.println("La distribucion de frecuencias es:");
        for (double i = t; Math.round(i*10000) <= 10000; i+=t) {
            vuelta+=1;
            System.out.println("Intervalo ["+ String.format("%.4f",(i-t))+", "+String.format("%.4f",(i))+"]: "+distribucion[vuelta-1]);
        }
        boolean agrupado=false;
        double[] v1;
        v1= new double[k/2];
        while (fe<5 && k%2==0){
            
            
            int j = 0;
            for (int i = 0; i < (k); i+=2) {
                
                v1[j]=(distribucion[i]+distribucion[i+1]);
                j++;
            }
            fe*=2;
            t*=2;
            k/=2;
            agrupado=true;
            
            vuelta=0;
            System.out.println("La distribucion de frecuencias es:");
            for (double i = t; Math.round(i*100) <= 100; i+=t) {
            vuelta+=1;
            System.out.println("Intervalo ["+(i-t)+", "+i+"]: "+v1[vuelta-1]);
            
        }
            
        }
        double chi=0;
        System.out.println("Frecuencia esperada: " + fe);
        if (agrupado){
            for (int i = 0; i < k; i++) {
                
                chi+= (Math.pow(v1[i]-fe, 2)) / fe;
            }    
        }
        else
            
        {for (int i = 0; i < k; i++) {
                chi+= (Math.pow((distribucion[i]-fe),2)) / fe;
            }
        }
        
        return chi;
    }
 
     //private double[] v;
public static void main(String[] args) {
        // TODO code application logic here
//        a)	Realizar un programa de genere una serie de 20 números aleatorios
//                entre 0 y 0,9999 (4 dígitos decimales) a partir de un valor numérico
//                indicado como raíz, utilizando los métodos congruenciales
//                mixto y multiplicativo. Las constantes a utilizar por los métodos 
////               deben ser ingresadas por  el usuario.  
////      Una vez que se listan los 20 números, debe permitir seguir la serie de a un valor por vez.  
//b)	Realizar un programa que efectúe la prueba de frecuencia (Test de Chi Cuadrado) sobre una 
//        serie generada a través del mecanismo provisto por el lenguaje utilizado para generar números 
//        pseudo-aleatorios. La cantidad de números a generar y de subintervalos debe ser recibida como
//        parámetro y la salida generada deberá incluir una gráfica que represente las frecuencias observadas
//        y esperadas (la gráfica se aceptará que se genere en base a un archivo de salida del programa, en Excel).
//        La serie generada debe por ser vista (bajar a archivo o visualizar en pantalla). 
//c)	Lo mismo que el punto anterior, pero utilizando el método congruencial mixto. 
 
 
    Scanner sc = new Scanner(System.in);
    boolean salir = false;
    int opcion; //Guardaremos la opcion del usuario
 
    while (!salir) {
 
        System.out.println("1. Metodo congruencial multiplicativo mixto");
        System.out.println("2. Metodo congruencial multiplicativo");
        System.out.println("3. Prueba de frecuencia (Test de Chi Cuadrado)");
        System.out.println("4. Prueba de frecuencia (Test de Chi Cuadrado)con cong mixto");
        System.out.println("5. Salir");
 
    try {

        System.out.println("Escribe una de las opciones");
        opcion = sc.nextInt();

    switch (opcion) {
        case 1:
            System.out.println("Has seleccionado la opcion 1");
            System.out.println("1. Metodo congruencial multiplicativo mixto");


            double[] v;
            v = new double [20];
            int x0;
            double g = 3; 

            //double a = 1+4*k; 
            //double c = 7;
            double m = 8;
            double r; 

            //INGRESO DE DATOS 
            System.out.println("Empezaremos con el ingreso de datos...");
            //Semilla
            System.out.println("Ingrese un valor inicial o semilla : ");
            //System.out.println("x0");
            x0= sc.nextInt();
            //Cte multiplicativa
            int a= 0;
            boolean var=false;
            while(var==false){
                System.out.println("Ingrese la constante multiplicativa");
                a=sc.nextInt();
                if (((a-1)%4)==0 && a>0){
                    System.out.println("El numero ingresado es correcto");
                    var= true;}
                else {
                    System.out.println("El numero ingresado no es correcto recuerde que debe cumplir con a = 1+4k... intente nuevamente");
                    var=false;
                    }
            }
            //Cte aditiva

            boolean var1=false;

            System.out.println("Ingrese la constante aditiva");
            int c=sc.nextInt();
            boolean pr=true;

            pr=esPrimo(c);

            while(pr==false){
                System.out.println("El numero ingresado es incorrecto, debe ser primo.");
                System.out.println("Ingrese un nuevo numero");
                c=sc.nextInt();
                pr=esPrimo(c);
            }


            //FALTA LO DE NUMERO PRIMO 

            //Modulo 

            System.out.println("Ingrese el modulo");
            int mod=sc.nextInt();
            if (((Math.sqrt(mod))%2)==0) {   
                System.out.println("El numero ingresado es correcto");
                var1= true;}
            else {
                System.out.println("El numero ingresado no es correcto, recuerde que m= 2^g... intente nuevamente");
                var1=false;  }

            System.out.println("Finalizamos el ingreso de datos");

            //METODO CONGRUENCIAL MULTIPLICATIVO MIXTO

            double x1 = (a * x0 + c) % m;
            //System.out.println("xi+1 = " + x1);

            r = x1 /(m);//se saca el menos uno para que no incluya el 1 
            System.out.println("Los 20 valores aleatorios son: ");
            System.out.println(String.format("%.4f", r));
            v[0]= r; 
            for (int i = 1 ; i <20 ; i++) {

                x1 = (a * x1 + c) % m;

                //System.out.println("xi+1= " + x1);
                r = x1 /(m); // se saca el menos uno para que no incluya el 1
                //System.out.println("r= ");
                System.out.println(String.format("%.4f", r));
                v[i]= r; 
                }

    //PARA VER LOS NUMERO QUE YA PASARON DE A UNO 
            System.out.println("Quiere ver los numeros de la serie de a un valor por vez?");
            System.out.println("Ingrese s (si) o n (no)");
            String resp; 
            resp = sc.next();

            int j=0;
            while ("s".equals(resp))
            {

                System.out.println(String.format("%.4f", v[j]));
                j++;
            if (j == 20){System.out.println("No hay mas numero."); break;} 
            System.out.println("Quiere ver el siguiente numero?");
            resp = sc.next();

            }       


            //PARA VER LA CONTINUACION DE LA SERIE UNO A UNO 
            System.out.println("Quiere ver la continuacion de los numeros de la serie de a un valor por vez?");
            System.out.println("Ingrese s (si) o n (no)");
            String res; 
            res = sc.next();

            //int z=0;
            while ("s".equals(res))
            {

                x1 = (a * x1 + c) % m;

                //System.out.println("xi+1= " + x1);
                r = x1 /(m); // se saca el menos uno para que no incluya el 1
                //System.out.println("r= ");
                System.out.println(String.format("%.4f", r));
                System.out.println("Quiere ver el siguiente numero?");
                res = sc.next();

            }
            break;
    case 2:
           System.out.println("Has seleccionado la opcion 2");
           System.out.println("2. Metodo congruencial multiplicativo");                 
                        
            //  Metodo congruencial Multiplicativo
    
            //INGRESO DE DATOS 
            System.out.println("Empezaremos con el ingreso de datos...");
            //Semilla
            //System.out.println("x0");
            boolean impar = false;
            int x00=0;
            while(impar==false){
            System.out.println("Ingrese un valor inicial o semilla : ");

            x00 = sc.nextInt();
            if (x00%2==0){
                impar=false;
                System.out.println("El numero ingresado es incorrecto... recuerde que tiene que ser impar");
            }
            else{
                impar = true;
                System.out.println("El numero ingresado es correcto");
            }}
            //Cte multiplicativa
            int aa = 0;
            boolean varr=false;
            while(varr==false){
            System.out.println("Ingrese la constante multiplicativa");
            aa=sc.nextInt();
            if ((((aa-3)%8)==0 || ((aa-5)%8)==0) && (aa>0)){
                System.out.println("El numero ingresado es correcto");
                varr= true;}
            else {
                System.out.println("El numero ingresado no es correcto recuerde que debe cumplir con a = 3+8k o a=5+8k... intente nuevamente");
                varr=false;
            }} 

    //Modulo 
            boolean var11=false;
            System.out.println("Ingrese el modulo");
            int modd=sc.nextInt();
            if (((Math.sqrt(modd))%2)==0) {   
              System.out.println("El numero ingresado es correcto");
                var11= true;}
            else {
                System.out.println("El numero ingresado no es correcto, recuerde que m= 2^g... intente nuevamente");
                var11=false;  }

            System.out.println("Finalizamos el ingreso de datos");
    //METODO CONGRUENCIAL MULTIPLICATIVO 

            double v1[] = generadorMCMu(x00, aa, modd, 20);
            //PARA VER LOS NUMERO QUE YA PASARON DE A UNO 
    //        System.out.println("Quiere ver los numeros de la serie de a un valor por vez?");
    //        System.out.println("Ingrese s (si) o n (no)");
    //        String cad; 
    //        cad = sc.next();
    //                
    //        int l=0;
    //        while ("s".equals(cad))
    //        {
    //       
    //            System.out.println(String.format("%.4f", v1[l]));
    //            l++;
    //            if (l == 20){System.out.println("No hay mas numero."); break;} 
    //            System.out.println("Quiere ver el siguiente numero?");
    //            cad = sc.next();
    //       
    //        }


            //PARA VER LA CONTINUACION DE LA SERIE UNO A UNO 
            System.out.println("Quiere ver la continuacion de los numeros de la serie de a un valor por vez?");
            System.out.println("Ingrese s (si) o n (no)");
            String cadd; 
            cadd = sc.next();

            //int z=0;
            x1=v1[19]*modd;
            while ("s".equals(cadd))
            {

                x1 = (aa * x1) % modd;
                //System.out.println("xi+1= " + x1);

                r = x1 /(modd); // se saca el menos uno para que no incluya el 1
                //System.out.println("r= ");
                System.out.println(String.format("%.4f", r));
                System.out.println("Quiere ver el siguiente numero?");
                cadd = sc.next();
            }

            break;
        case 3:
            System.out.println("Has seleccionado la opcion 3");
            System.out.println("3. Prueba de frecuencia (Test de Chi Cuadrado)");
            
            //Cantidad de numeros de la serie
            System.out.println("__________________________________________");
            System.out.println("Ingrese la cantidad de numeros a generar.");
            int n=sc.nextInt();
            
            double[] v2;
            v2 = new double [n];
            
            for (int i = 0; i < n; i++) {
                v2[i]=Math.random();
                System.out.println(v2[i]);
            }
            
            System.out.println("__________________________________________");
            System.out.println("Ingrese el número de intervalos que desea en la distribución de frecuencias:");
            int k = sc.nextInt();
            double chi = chiCuadr(v2, k);
            
            System.out.println("Variable Chi cuadrado cacluclada es: "+ chi);
            break;
        case 4:
            System.out.println("Has seleccionado la opcion 4");
            System.out.println("4. Prueba de frecuencia (Test de Chi Cuadrado)con cong mixto");
            //INGRESO DE DATOS 
            System.out.println("Empezaremos con el ingreso de datos...");
            //Semilla
            //System.out.println("x0");
            impar = false;
            x0=0;
            while(impar==false){
                System.out.println("__________________________________________");
                System.out.println("Ingrese un valor inicial o semilla : ");

                x0 = sc.nextInt();
                
                if (x0%2==0){
                    impar=false;
                    System.out.println("El numero ingresado es incorrecto... recuerde que tiene que ser impar");
                }
                else{
                    impar = true;
                    System.out.println("El numero ingresado es correcto");
            }}
            //Cte multiplicativa
            a= 0;
            var=false;
            while(var==false){
                System.out.println("__________________________________________");
                System.out.println("Ingrese la constante multiplicativa");
                a=sc.nextInt();
                if (((a-1)%4)==0 && a>0){
                    System.out.println("El numero ingresado es correcto");
                    var= true;}
                else {
                    System.out.println("El numero ingresado no es correcto recuerde que debe cumplir con a = 1+4k... intente nuevamente");
                    var=false;
                    }
            }
            
            //Cte aditiva

            var1=false;
            
            System.out.println("__________________________________________");
            System.out.println("Ingrese la constante aditiva");
            c=sc.nextInt();
            pr=true;

            pr=esPrimo(c);

            while(pr==false){
                System.out.println("El numero ingresado es incorrecto, debe ser primo.");
                System.out.println("Ingrese un nuevo numero");
                c=sc.nextInt();
                pr=esPrimo(c);
            }
            //Modulo 
            var11=false;
            int mod11=4;
            while(var11==false){
                System.out.println("__________________________________________");
                System.out.println("Ingrese el modulo");
                mod11=sc.nextInt();
                if (((Math.sqrt(mod11))%2)==0) {   
                  System.out.println("El numero ingresado es correcto");
                    var11= true;}
                else {
                    System.out.println("El numero ingresado no es correcto, recuerde que m= 2^g... intente nuevamente");
                    var11=false;  }
            }
            //Cantidad de numeros de la serie
            System.out.println("__________________________________________");
            System.out.println("Ingrese la cantidad de numeros a generar.");
            n = sc.nextInt();
            
            System.out.println("Finalizamos el ingreso de datos");
            
            double[] v3;
            v3 = new double [n];
            
            //v3 = generadorMixto(x0, a, c, mod, n);
            v3=generadorMCMu(x0, a, mod11, n);
            
            System.out.println("__________________________________________");
            System.out.println("Ingrese el número de intervalos que desea en la distribución de frecuencias:");
            k = sc.nextInt();
            chi = chiCuadr(v3, k);
            
            System.out.println("Variable Chi cuadrado cacluclada es: "+ chi);
            
            break;
        case 5:
            salir = true;
            System.out.println("SALIR.");
            break;
        default:
            System.out.println("Solo números entre 1 y 5");
    }
    } catch (InputMismatchException e) {
        System.out.println("Debes insertar un número");
        sc.next();
    }
 
}

}
    

}