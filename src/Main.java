 /*
   * DESARROLLAR UN HOME BANKING CON LAS SIGUIENTES OPERACIONES
   * Logueo con nombre de usuario y contraseña
   * saldo de cuenta
   * opcion de ingreso y extraccion de dinero
   * opcion de transferencia por CBU, ALIAS
   * cierre de sesion
   **/


 import java.util.Scanner;

 public class Main {

    public static void main(String[] args) {

    String userInput, userInputName, userInputPassword = null;


    messages("Bienvenido a su terminal Home-Banking.");
    messages("Ingrese sus credenciales para continuar:");

    Scanner keyboardInput;
    keyboardInput = new Scanner(System.in);

    messages("Ingrese su nombre de usuario:");
    userInputName = keyboardInput.nextLine();
    messages("Ingrese su contraseña:");
    userInputPassword = keyboardInput.nextLine();

    userAuthentication(userInputName, userInputPassword);

    messages("----- MENU PRINCIPAL -----");
    messages("ingrese el numero de la opcion deseada para operar");
    operationMenu();
    sessionFinish();
    }




    //Metodos
    static void messages(String userMessage) {
        System.out.println(userMessage);
    }

    static void sessionFinish() {
        System.out.println("La Sesion ha finalizado correctamente.");
    }

    static void userAuthentication(String userInputName, String userInputPassword) {
         String user = "ignacio"; //user name from database
         String pass = "1234"; //user password from database

        if (userInputName.equals(user) && userInputPassword.equals(pass)){
            System.out.println("Login Successful");
        } else {
            System.out.println("Verifique los datos ingresados");
        }

    }

    public static void operationMenu(){
        short userOptionMenu = 0;
        float cashOut, multipleNumber = 10, rest;
        float balance = 5000;
        String goBack;

        Scanner keyboardInputFunc;
        keyboardInputFunc = new Scanner(System.in);

        System.out.println("(1)-Saldos.");
        System.out.println("(2)-Exctracciones");
        System.out.println("(3)-Deposito en cuenta propia..");
        System.out.println("(4)-Transferencias.");
        System.out.println("(0)-Finalizar.");

        messages("Ingrese una opcion para continuar.");
        userOptionMenu = keyboardInputFunc.nextShort();
        switch (userOptionMenu) {
            case 1:
                messages("+++++ Saldos +++++");
                System.out.println("su saldo actual es de: $" + balance +" .Pesos");

                System.out.println("Para volver al menu principal presione s");
                goBack = keyboardInputFunc.next();
                while (goBack != "s"){
                    operationMenu();
                }
            break;

            case 2:
                messages("+++++ Extracciones +++++");

                System.out.println("Ingrese la cantidad que desea retirar");

                cashOut = keyboardInputFunc.nextFloat();

                rest = cashOut % multipleNumber;
                if (rest == 0 ) {
                    balance -= cashOut;
                    System.out.println("Su saldo de cuenta actual es: $" + balance +".");
                } else {
                    System.out.println("El monto debe ser multiplo de 10.");
                }

                break;
            case 3:
                messages("+++++ DEPOSITO EN CUENTA PROPIA +++++");

                break;

            case 0:
                sessionFinish();
        }

    }
}


