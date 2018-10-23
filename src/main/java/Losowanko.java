import java.util.Random;

class Losowanko {

    Losowanko(){}

    String wylosuj(){
        StringBuilder sb= new StringBuilder();
        Random random=new Random();
        boolean petla= true;
        boolean[] czyBylo=new boolean[10];
        for(int i=0; i<10; i++){
            czyBylo[i]=false;
        }
        int licznik=0;
        while(petla){
            int losowanie=random.nextInt(10);
            if(!czyBylo[losowanie]){
                sb.append(losowanie);
                licznik++;
                czyBylo[losowanie]=true;
            }
            else if(licznik==10){
                petla=false;
            }
        }
        return sb.toString();
    }
}
