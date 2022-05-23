import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Robo robot = new Robo();
    int trueA = 1;
    while (trueA == 1) {
      Scanner reader = new Scanner(System.in);
      if (robot.bateria <= 10) {
        System.out.println ("ALERTA; SISTEMA ENCERRANDO PARA CARREGAMENTO; BATERIA EM NÍVEIS CRITICOS; ALERTA;");
        trueA = 0;
        break;
      }
      System.out.println("DIGITE UMA AÇÃO:");
      System.out.println("AÇÕES: GIRAR, ANDAR, VOLTAR, STATUS;");
      String fazerInput = reader.nextLine();
      robot.fazer(fazerInput);
    }
  }
}

class Robo {
  int bateriaMax = 100;
  int bateria = bateriaMax;

  public void fazer(String action) {
    Scanner reader = new Scanner(System.in);
    switch(action) {
      case "GIRAR":
        System.out.println("DIGITE QUANTOS GRAUS O ROBO DEVERA GIRAR, NEGATIVO PARA A ESQUERDA;");
        int grausInput = reader.nextInt();
        if (bateria > 10) {
          System.out.println("GIRANDO " + grausInput + "º;");
          bateria -= 10;
          bateriaGasta(10);
        } else {
          bateriaFaltando();
        }
        break;
      case "ANDAR":
        System.out.println("DIGITE QUANTOS M O ROBO DEVERA ANDAR");
        int andarInput = reader.nextInt();
        if (andarInput > 0) {
          if (bateria > andarInput) {
            System.out.println("ANDANDO " + andarInput + "M;");
            bateria -= andarInput;
            bateriaGasta(andarInput);
          } else {
            bateriaFaltando();
          }
          } else {
          System.out.println("NÃO E PERMITIDO NÚMEROS NEGATIVOS; ERRO;");
          }
        break;
      case "VOLTAR":
        System.out.println("DIGITE QUANTOS M O ROBO DEVERA VOLTAR");
        int voltarInput = reader.nextInt();
        if (voltarInput > 0) {
          if (bateria > voltarInput) {
            System.out.println("VOLTANDO " + voltarInput + "M;");
            bateria -= voltarInput;
            bateriaGasta(voltarInput);
          } else {
            bateriaFaltando();
          }
          } else {
          System.out.println("NÃO E PERMITIDO NÚMEROS NEGATIVOS; ERRO;");
          }
        break;
      case "STATUS":
        System.out.println("BATERIA ATUAL = " + bateria + "%;");
        System.out.println("APERTE ENTER PARA CONTINUAR;");
        reader.nextLine();
        break;
      default:
        System.out.println("ERRO;");
        System.out.println("APERTE ENTER PARA CONTINUAR;");
        reader.nextLine();
    }  
  }
  public void bateriaFaltando(){
    Scanner reader = new Scanner(System.in);
    System.out.println("BATERIA FALTANDO PARA A AÇÃO; ERRO;");
    System.out.println("APERTE ENTER PARA CONTINUAR;");
    reader.nextLine();
  }

  public void bateriaGasta(int gasto){
    Scanner reader = new Scanner(System.in);
    System.out.println("BATERIA GASTA NA AÇÃO = " + gasto + "%;");
    System.out.println("APERTE ENTER PARA CONTINUAR;");
    reader.nextLine();
  }
}
