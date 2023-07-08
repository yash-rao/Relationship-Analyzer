import java.util.*;  

public class Relationship_analyzer
{
    private int arr[];
    private int size;
    private char[] op_string;
    private int op_len;
    
    public Relationship_analyzer(String person_1,String person_2,String op){
        String full_string = person_1.trim()+op.trim()+person_2.trim();
        op_string= full_string.toLowerCase().toCharArray();
        size = op_string.length;
        arr = new int[size];
    }
    
    public void display(){
        System.out.println("Size : "+size);
        // System.out.println("Size : ");
    }
    public int Actual_friendship(int arr[],int t){
        int pointer=0;
        int track=0;
        int end_pointer=t-1;
        System.out.print("\n");
        while (pointer<end_pointer){
            arr[pointer]=arr[pointer]+arr[end_pointer];
            track++;
            System.out.print(" "+arr[pointer]);
            pointer++;
            end_pointer--;
        }
        if(t%2!=0){
            arr[pointer]=arr[(t-1)/2];
            track++;
        }
        if(track>2){
        Actual_friendship(arr,track);
        }
        int result = (arr[0]*10)+arr[1];
        if (result>100){
            Actual_friendship(arr,track);
        }
        return result;
    }
    public void Calculate(){
        int start=0,i,track=0;
        int pointer=0;
        char c;
        int count;
        for(i=start;i<size;i++){
            pointer=i;
            c = op_string[pointer];
            count=0;
            if(c=='*'){
                continue;
            }
            while(pointer<size){
                if (c==op_string[pointer]){
                    op_string[pointer]='*';
                    count++;
                }
                pointer++;
            }
            track++;
            arr[i]=count;
            System.out.print("  "+arr[i]);
        }
        int res=Actual_friendship(arr,track);
        System.out.println("\nTotal Friendship is : "+res+"%");
    }
    
	public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);
		System.out.print("Your Name : ");
		String person_1= sc.nextLine();
		System.out.print("Your beloved name : ");
		String person_2= sc.nextLine();
		System.out.print("Calculate Friendship, Love etc : ");
		String operation = sc.nextLine();
		Relationship_analyzer obj1 = new Relationship_analyzer(person_1,person_2,operation);
		obj1.display();
		obj1.Calculate();
	}
}
