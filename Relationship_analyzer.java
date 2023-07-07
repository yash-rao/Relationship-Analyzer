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
    public void Calculate(){
        int start=0,end,i;
        int pointer=0;
        end = size-1;
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
            arr[i]=count;
            System.out.print("  "+arr[i]);
        }
        
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
