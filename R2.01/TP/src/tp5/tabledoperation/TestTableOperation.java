package tp5.tabledoperation;

import java.util.Scanner;

public class TestTableOperation {
    public static void main(String[] args) {
        Scanner lecteur = new Scanner(System.in);
        int choix;

        System.out.println("Addition 1 ou Soustraction 2 ou Multiplication 3 ?");
        do{
            choix = lecteur.nextInt();
            lecteur.nextLine();
            if(choix !=1 && choix !=2 && choix!=3){
                System.out.println("Merci de répondre 1 ou 2 ou 3 ?");
            }
        }while (choix != 1 && choix != 2 && choix !=3);

        System.out.println("Donnez les réponses aux opérations : ");
        TableDoperation tabAdd = new TableDoperation(OperationEnum.ADDITION);
        TableDoperation tabSub = new TableDoperation(OperationEnum.SOUSTRACTION);
        TableDoperation tabMul = new TableDoperation(OperationEnum.MULTIPLICATION);

        for(int i=0; i < tabAdd.getNombreDOperations(); i++){
            if(choix == 1){
                System.out.println(tabAdd.getOperation(i));
                System.out.println("Nombre de réponses justes : " + tabAdd.getNombreReponsesJustes());
            }else if(choix == 2){
                System.out.println(tabSub.getOperation(i));
                System.out.println("Nombre de réponses justes : " + tabSub.getNombreReponsesJustes());
            }else{
                System.out.println(tabMul.getOperation(i));
                System.out.println("Nombre de réponses justes : " + tabMul.getNombreReponsesJustes());
            }

        }
    }
}
