/**
 * 
 */

		function calculateLiquidKv(Q,P1,P2,G,pressureUnit){
			if(Q == ''){
				alert('请输入流量!');
				return;
			}
			if(P1 == ''){
				alert('请输入进口压力!');
				return;
			}
			if(P2 == ''){
				alert('请输入出口压力!');
				return;
			}
			if(G == ''){
				alert('请输入比重!');
				return;
			}			
			
			if(!$.isNumeric(Q)){
				alert('流量必须是数字!');
				return;				
			}			
			if(!$.isNumeric(P1)){
				alert('进口压力必须是数字!');
				return;
			}				
			if(!$.isNumeric(P2)){
				alert('出口压力必须是数字!');
				return;
			}				
			if(!$.isNumeric(G)){
				alert('比重必须是数字!');
				return;
			}	
			var numQ = new Number(Q);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numG = new Number(G);
			
			if(numQ <= 0 ){
				alert('流量必须大于0!');
				return;
			}		
			if(numP1 <= numP2){
				alert('进口压力必须大于出口压力!');
				return;
			}				
			if(numG <= 0){
				alert('比重必须大于0!');
				return;
			}						
						
			if(pressureUnit == 'MPa'){
				numP1 = numP1 * 10;
				numP2 = numP2 * 10;
			}
			else if(pressureUnit == 'KPa'){
				numP1 = numP1 / 100;
				numP2 = numP2 / 100;
			}			
			
			return numQ * Math.sqrt(numG / (numP1 - numP2));
		}
		
		function calculateGasCv(Q,P1,P2,G,T,pressureUnit){
			//alert(Q + ',' + P1 + ',' + P2 + ',' + G + ',' + T)
			if(Q == ''){
				alert('请输入流量!');
				return;
			}
			if(P1 == ''){
				alert('请输入进口压力!');
				return;
			}
			if(P2 == ''){
				alert('请输入出口压力!');
				return;
			}
			if(G == ''){
				alert('请输入比重!');
				return;
			}	
			if(T == ''){
				alert('请输入流体温度!');
				return;
			}
			
			if(!$.isNumeric(Q)){
				alert('流量必须是数字!');
				return;				
			}			
			if(!$.isNumeric(P1)){
				alert('进口压力必须是数字!');
				return;
			}				
			if(!$.isNumeric(P2)){
				alert('出口压力必须是数字!');
				return;
			}				
			if(!$.isNumeric(G)){
				alert('比重必须是数字!');
				return;
			}
			if(!$.isNumeric(T)){
				alert('流体温度必须是数字!');
				return;
			}
			
			var numQ = new Number(Q);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numG = new Number(G);
			var numT = new Number(T);			
			
			if(numQ <= 0 ){
				alert('流量必须大于0!');
				return;
			}		
			if(numP1 <= numP2){
				alert('进口压力必须大于出口压力!');
				return;
			}				
			if(numG <= 0){
				alert('比重必须大于0!');
				return;
			}	
			if(numT <= -273){
				alert('流体温度必须大于-273!');
				return;
			}			
						
			if(pressureUnit == 'MPa'){
				numP1 = numP1 * 10;
				numP2 = numP2 * 10;
			}
			else if(pressureUnit == 'KPa'){
				numP1 = numP1 / 100;
				numP2 = numP2 / 100;
			}
			
			var deltaP = numP1 - numP2;
			if(deltaP < (numP1 / 2))
				return Math.sqrt(numG * (273 + numT) / (deltaP * (numP1 + numP2))) * numQ / 287;
			else
				return Math.sqrt(numG * (273 + numT)) * Q / (249 * P1);							
		}
		
		function calculateVaperCv(W,P1,P2,overT,pressureUnit){
			if(W == ''){
				alert('请输入流量!');
				return;
			}
			if(P1 == ''){
				alert('请输入进口压力!');
				return;
			}
			if(P2 == ''){
				alert('请输入出口压力!');
				return;
			}
			if(overT == ''){
				alert('请输入过热温度!');
				return;
			}			
			
			if(!$.isNumeric(W)){
				alert('流量必须是数字!');
				return;				
			}			
			if(!$.isNumeric(P1)){
				alert('进口压力必须是数字!');
				return;
			}				
			if(!$.isNumeric(P2)){
				alert('出口压力必须是数字!');
				return;
			}
			if(!$.isNumeric(overT)){
				alert('流体温度必须是数字!');
				return;
			}
			
			var numW = new Number(W);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numOverT = new Number(overT);			
			
			if(numW <= 0 ){
				alert('流量必须大于0!');
				return;
			}		
			if(numP1 <= numP2){
				alert('进口压力必须大于出口压力!');
				return;
			}
						
			if(pressureUnit == 'MPa'){
				numP1 = numP1 * 10;
				numP2 = numP2 * 10;
			}
			else if(pressureUnit == 'KPa'){
				numP1 = numP1 / 100;
				numP2 = numP2 / 100;
			}

			var deltaP = numP1 - numP2;
			if(deltaP < (numP1 / 2))
				return numW * (0.0013 * numOverT + 1) / (Math.sqrt(deltaP * (numP1 + numP2)) * 13.67);
			else
				return numW * (0.0013 * numOverT + 1) / (11.9 * numP1);				
		}
		
		
		function calculateKByEqualPercentage(selectedKv,Kv,R){
			if(selectedKv == ''){
				alert('请输入选用Kv!');
				return;
			}
			if(Kv == ''){
				alert('请输入计算Kv!');
				return;
			}
			if(R == ''){
				alert('请输入可调比!');
				return;
			}		
			
			if(!$.isNumeric(selectedKv)){
				alert('选用Kv必须是数字!');
				return;				
			}			
			if(!$.isNumeric(Kv)){
				alert('计算Kv必须是数字!');
				return;
			}				
			if(!$.isNumeric(R)){
				alert('可调比必须是数字!');
				return;
			}	
			
			var numSelectedKv = new Number(selectedKv);
			var numKv = new Number(Kv);
			var numR = new Number(R);
			
			if(numSelectedKv <= 0){
				alert('选用Kv必须大于0!');
				return;
			}
			if(numKv <= 0){
				alert('计算Kv必须大于0!');
				return;
			}
			if(numSelectedKv < numKv){
				alert('选用Kv必须大于等于计算Kv!');
				return;
			}
			if(numR <= 0){
				alert('可调比必须大于0!');
				return;
			}
			if(numR == 1){
				alert('可调比不能等于1!');
				return;
			}			
			
			var m = numSelectedKv / numKv;
			return 100 * (1 - (Math.log(m) / Math.log(numR)));
		}
		
		function calculateKByLinear(selectedKv,Kv,R){
			if(selectedKv == ''){
				alert('请输入选用Kv!');
				return;
			}
			if(Kv == ''){
				alert('请输入计算Kv!');
				return;
			}
			if(R == ''){
				alert('请输入可调比!');
				return;
			}		
			
			if(!$.isNumeric(selectedKv)){
				alert('选用Kv必须是数字!');
				return;				
			}			
			if(!$.isNumeric(Kv)){
				alert('计算Kv必须是数字!');
				return;
			}				
			if(!$.isNumeric(R)){
				alert('可调比必须是数字!');
				return;
			}	
			
			var numSelectedKv = new Number(selectedKv);
			var numKv = new Number(Kv);
			var numR = new Number(R);
			
			if(numSelectedKv <= 0){
				alert('选用Kv必须大于0!');
				return;
			}
			if(numKv <= 0){
				alert('计算Kv必须大于0!');
				return;
			}
			if(numSelectedKv < numKv){
				alert('选用Kv必须大于等于计算Kv!');
				return;
			}
			if(numR <= 0){
				alert('可调比必须大于0!');
				return;
			}
			if(numR == 1){
				alert('可调比不能等于1!');
				return;
			}
			
			var m = numSelectedKv / numKv;
			return 100 * (numR - m) / (m * (numR - 1));
		}
		
		function calculateKByModifiedParabolic(selectedKv,Kv,R){
			if(selectedKv == ''){
				alert('请输入选用Kv!');
				return;
			}
			if(Kv == ''){
				alert('请输入计算Kv!');
				return;
			}
			if(R == ''){
				alert('请输入可调比!');
				return;
			}		
			
			if(!$.isNumeric(selectedKv)){
				alert('选用Kv必须是数字!');
				return;				
			}			
			if(!$.isNumeric(Kv)){
				alert('计算Kv必须是数字!');
				return;
			}				
			if(!$.isNumeric(R)){
				alert('可调比必须是数字!');
				return;
			}	
			
			var numSelectedKv = new Number(selectedKv);
			var numKv = new Number(Kv);
			var numR = new Number(R);
			
			if(numSelectedKv <= 0){
				alert('选用Kv必须大于0!');
				return;
			}
			if(numKv <= 0){
				alert('计算Kv必须大于0!');
				return;
			}
			if(numSelectedKv < numKv){
				alert('选用Kv必须大于等于计算Kv!');
				return;
			}
			if(numR <= 0){
				alert('可调比必须大于0!');
				return;
			}
			if(numR == 1){
				alert('可调比不能等于1!');
				return;
			}
			
			var m = numSelectedKv / numKv;
			return 100 * (Math.sqrt(numR / m) - 1) / (Math.sqrt(numR) - 1);
		}
		
		function calculateKBySquareRoot(selectedKv,Kv,R){
			if(selectedKv == ''){
				alert('请输入选用Kv!');
				return;
			}
			if(Kv == ''){
				alert('请输入计算Kv!');
				return;
			}
			if(R == ''){
				alert('请输入可调比!');
				return;
			}		
			
			if(!$.isNumeric(selectedKv)){
				alert('选用Kv必须是数字!');
				return;				
			}			
			if(!$.isNumeric(Kv)){
				alert('计算Kv必须是数字!');
				return;
			}				
			if(!$.isNumeric(R)){
				alert('可调比必须是数字!');
				return;
			}	
			
			var numSelectedKv = new Number(selectedKv);
			var numKv = new Number(Kv);
			var numR = new Number(R);
			
			if(numSelectedKv <= 0){
				alert('选用Kv必须大于0!');
				return;
			}
			if(numKv <= 0){
				alert('计算Kv必须大于0!');
				return;
			}
			if(numSelectedKv < numKv){
				alert('选用Kv必须大于等于计算Kv!');
				return;
			}
			if(numR <= 1){
				alert('可调比必须大于1!');
				return;
			}
			
			var m = numSelectedKv / numKv;
			return 100 * ( 1 - Math.sqrt(numR * (m - 1) / (m * (numR - 1))));
		}
		
		
		
		