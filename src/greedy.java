import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class greedy {
	

	public static void main(String[] args) throws IOException{
		File folder = new File("input"); //create the file
		File[] listfile = folder.listFiles();
		for(int a=0;a<listfile.length;a++){
		
		Scanner sc = new Scanner(listfile[a]);//new scan
		int size = sc.nextInt();//read total coordinate
		int[][] num = new int[size][2];
		int number=0;
		int[][] count = new int[size][2];
		ArrayList<Integer> Ver = new ArrayList<Integer>();
		ArrayList<Integer> Hor = new ArrayList<Integer>();
		for (int i=0;i<size;i++){//run loop to store all the coorinate to num array
			num[i][0]=sc.nextInt();//put vertical coordinate to num[i][0] array
			num[i][1]=sc.nextInt();//put horizontal coordinate to num[i][1] array
			if(sc.hasNextLine()){
				sc.nextLine();//scan next line
				}
			
		}
		String fileout = "greedy_solution"+listfile[a].getName().charAt(8)+listfile[a].getName().charAt(9)+".txt";
		File dicfile = new File("output_greedy");
		File actfile = new File(dicfile,fileout);
		FileWriter file =new FileWriter(actfile);  //  create FileWriter
		BufferedWriter writer = new BufferedWriter(file);  // create BufferedWriter
		//writer.write(number+"");
		writer.newLine();
		writer.newLine();
		
		for(int i=0;i<size-1;i++){//
			for(int j=i+1;j<size;j++){				
				Ver.add(num[i][0]);
				Ver.add(num[j][0]);
				Hor.add(num[i][1]);
				Hor.add(num[j][1]);		
				
			}
			
			
					
		}
		while(Ver.size()!=0){
		  for(int i=0;i<Ver.size()/2;i++){
			for(int j=0;j<size-1;j++){
				float v1=(float)(num[j][0]+0.5);
				float h1=(float)(num[j][1]+0.5);
				int k=(int)(Ver.get(2*i));
				int l=(int)(Ver.get(2*i+1));
				int m=(int)(Hor.get(2*i));
				int n=(int)(Hor.get(2*i+1));
				if(k<v1&&l>v1){
				
			          count[j][0]++;
				}

				if(m<h1&&n>h1){
				      count[j][1]++;
			    }
			    
			}
			    }
		        int VmaxIndex=0;
		        int HmaxIndex=0;
		    	for (int i = 1; i < size-1; i++){
		    	   int MaxV = count[i][0];
		    	   int MaxH = count[i][1];
		    	   if ((MaxV > count[VmaxIndex][0])){
		    	   VmaxIndex = i;
		    	 
		    	   
		    	  }
		    	   if ((MaxH > count[HmaxIndex][1])){
			    	   HmaxIndex = i;
			    	   
			    	  }
		    	 
		    }

		    	

		    	if(count[VmaxIndex][0]>=count[HmaxIndex][1]){
		    		float v2=(float)(num[VmaxIndex][0]+0.5);
		    		writer.write("v "+v2);
		    		writer.newLine();
		    		number++;
		    		for(int i=Ver.size()/2-1;i>=0;i--){
		    			int k=(int)(Ver.get(2*i));
						int l=(int)(Ver.get(2*i+1));
						if(k<v2&&l>v2){
		    				Ver.remove(2*i);
		    				Ver.remove(2*i);
		    				Hor.remove(2*i);
		    				Hor.remove(2*i);		    				
		    			}
		    		}
		    	}
		    	else{
		    		float h2=(float)(num[HmaxIndex][1]+0.5);
		    		writer.write("h "+h2);
		    		writer.newLine();
		    		number++;
		    		for(int i=Hor.size()/2-1;i>=0;i--){
		    			int k=(int)(Hor.get(2*i));
						int l=(int)(Hor.get(2*i+1));  			
						if(k<h2&&l>h2){
		    				Ver.remove(2*i);
		    				Ver.remove(2*i);
		    				Hor.remove(2*i);
		    				Hor.remove(2*i);
		    			}
		    		}
		    	
		    	}
		    	
		    	for (int i = 0; i < size-1; i++){
			    	
			    	   count[i][0]=0;
			    	   count[i][1]=0;
			    	   
			    	  }
		    	
		    	
		} 
		writer.close();	
		RandomAccessFile f = new RandomAccessFile(actfile,"rw");
    	f.seek(0); // to the beginning
    	String numberAsString = Integer.toString(number);
    	f.write(numberAsString.getBytes());
    	
    	f.close();	
    	
		
	
		
		
		
	
}
		
			         	
			
	}	

}
	
