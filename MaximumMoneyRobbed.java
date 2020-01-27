
public class MaximumMoneyRobbed {
	int flag[]=new int[5];
	int houses[]=new int[5];
	int size;
	int pos[]=new int[5];
	int temp;
	public MaximumMoneyRobbed(int arr[],int n)
	{
		try {
			if(n<=0) {
				throw new IllegalArgumentException("size must be greater than 0");
			}
			for(int i=0;i<n;i++) {
				houses[i]=arr[i];
			}
			size=n;
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("invalid size provided");
		}
	}
	//Using the pos array to find the maximum amount that can be robbed
	public int MaxHousesRobbed() {
		int tempSum=0,maxValue=0;
		int iterate,rank;
		for(iterate=0;iterate<size;iterate++)
		{
			for(rank=iterate;rank<size;rank++) {
				if(pos[rank]==0) {
					if(flag[pos[rank]+1]==0) {
						tempSum=tempSum+houses[pos[rank]];
						flag[pos[rank]]=1;
					}
					continue;
				}
				else if(pos[rank]==size-1) {
					if(flag[pos[rank]-1]==0) {
						tempSum=tempSum+houses[pos[rank]];
						flag[pos[rank]]=1;
					}
					continue;
				}
				else {
					if(flag[pos[rank]+1]==0 && flag[pos[rank]-1]==0) {
						tempSum=tempSum+houses[pos[rank]];
						flag[pos[rank]]=1;
					}
				}
			}
			if(tempSum>maxValue) {
				maxValue=tempSum;
			}	
			tempSum=0;
			flag=new int[5];
		}
		return maxValue;
	}
	
	//Sorting the houses in descending order and storing the new positions in pos array
	public int arraySorting(int tempArr[]) {
		for(int i=0;i<size;i++) {
			pos[i]=i;
		}
		for(int i=0;i<size;i++) {
			for(int j=0;j<size-1;j++){
				if(tempArr[j]<tempArr[j+1]){
					if(tempArr[j]<=0) {
						throw new IllegalArgumentException("Must be positive integer");
					}
					temp=pos[j];
					pos[j]=pos[j+1];
					pos[j+1]=temp;
					temp=tempArr[j];
					tempArr[j]=tempArr[j+1];
					tempArr[j+1]=temp;
				}
			}
		}
		return MaxHousesRobbed();
	}

}
