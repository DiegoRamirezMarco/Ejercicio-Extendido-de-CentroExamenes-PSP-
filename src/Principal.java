public class Principal {

    public static void main(String[] args) throws InterruptedException {
        if(args.length < 0){
            System.out.println("Se deben proporcionar argumentos");
        }

        BufferExamenes be = new BufferExamenes();

        for(String alumno : args){
            new ProductorExamenes(be);
            new Examinado(alumno,be);
        }
    }
}