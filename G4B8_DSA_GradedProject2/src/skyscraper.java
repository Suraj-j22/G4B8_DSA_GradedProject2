import java.util.Scanner;
public class skyscraper {
	static Scanner in=new Scanner(System.in);
	int floor[];
	int nooffloors;
	int sortedfloor[];
	
	
	void acceptfloors() {
		floor=new int[nooffloors];
		for(int i=0;i<nooffloors;i++) {
			System.out.println("Enter the floor size given on day : "+(i+1));
			floor[i]=in.nextInt();
		}
	}
	void order() {
		sortedfloor=new int[nooffloors];
		for(int i=0;i<nooffloors;i++)
		{
			sortedfloor[i]=floor[i];
		}
		for(int i=0;i<nooffloors;i++)  
		{
			for(int j=i+1;j<nooffloors;j++)  
			{
				if(sortedfloor[i]<sortedfloor[j])
				{
				int temp=sortedfloor[i];
				sortedfloor[i]=sortedfloor[j];
				sortedfloor[j]=temp;
				}
			}
		}
		
//		System.out.println("Unsorted floors:");
//		for(int i=0;i<nooffloors;i++)
//		{
//			System.out.println("      "+floor[i]);
//		}
//		System.out.println("Sorted floors:");
//		for(int i=0;i<nooffloors;i++)
//		{
//			System.out.println("      "+sortedfloor[i]);
//		}
		
		int b1=0;
		for(int i=0;i<nooffloors;i++)
		{
			System.out.println("Day : "+(i+1));
			
			if(sortedfloor[b1]==floor[i])
			{
				System.out.println("     "+floor[i]);
				if(b1<(nooffloors-1))
					b1=b1+1;
				else
				{
					System.out.println();
					return;
				}
				b1=recursion(i,b1);
			}
		}
	}
		int recursion(int i2,int b2)
		{
			int i3=i2;
			while(i2>=0)
			{
				if(sortedfloor[b2]==floor[i2])
				{
					System.out.println("     "+floor[i2]);
					if(b2<(nooffloors-1))
					{
						b2=b2+1;
						i2=(i3+1);
					}
					else
						System.out.println();
				}
				i2--;
			}
			return b2;
		}
	public static void main(String args[]) {
		skyscraper sky=new skyscraper();
		System.out.println("Enter the total no of floors in the building");
		sky.nooffloors=in.nextInt();
		sky.acceptfloors();
		sky.order();
	}
}
