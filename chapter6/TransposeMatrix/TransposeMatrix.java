public class TransposeMatrix{
	public static void main(String args[]){
		final int[][] original=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] b=new int[4][3];
		for(int i=0;i<original.length;i++){
			for(int j=0;j<original[i].length;j++){
				System.out.print(original[i][j]+" ");
				b[j][i]=original[i][j];
			}
			System.out.print("\n");
		}
		System.out.print("\n\n matrix transpose:\n");
		//transpose
		if(original.length>0){
			for(int i=0;i<original[0].length;i++){
				for(int j=0;j<original.length;j++){
					System.out.print(original[j][i]+" ");
				}
			System.out.print("\n");
			}
		}
		hehe(b);
	}
	public static void hehe(int[][] array){
		int[][] b=new int[4][3];
		b=array;
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b[i].length;j++){
				System.out.print(b[i][j]+" ");
			}
		System.out.print("\n");
		}
	}
}
