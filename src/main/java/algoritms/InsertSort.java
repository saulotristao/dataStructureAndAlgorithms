package algoritms;

public class InsertSort <T extends Number> {


    public static void main(String[] args) {
        Integer[] vals = new Integer[]{6,2,567,23,45,68,67};

        Integer[] valsorganized = insertSort(vals);

        for (Number n : valsorganized){
            System.out.print(n+ ", ");
        }
    }



        public static <T extends Number> T[] insertSort(T[] array){

            long startime = System.nanoTime();

            if(array.length <2){
                return array;
            }

            for (int i = 0; i < array.length; i++){
                T num = array [i];

                int j = i-1;

                while(j >=0 && array[j].doubleValue()> num.doubleValue()){
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1]= num;
            }
            System.out.println("\ntime"+ (System.nanoTime()-startime));

            return array;
    }
}

