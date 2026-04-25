public class NumberOfProvinces {
    static void dfs(int[][] isConnected,boolean[] visited,int city) {
        visited[city]=true;
        for (int j=0;j<isConnected.length;j++) {
            if (isConnected[city][j]==1&&!visited[j]) {
                dfs(isConnected,visited,j);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int provinces=0;
        for (int i=0;i<n;i++){
            if (!visited[i]){
                dfs(isConnected,visited,i);
                provinces++;
            }
        }
        return provinces;
    }

    public static void main(String[] args) {
        int[][] isConnected = {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };

        System.out.println(findCircleNum(isConnected)); 
    }
}