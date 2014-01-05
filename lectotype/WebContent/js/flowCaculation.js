/**
 * 
 */

		function calculateLiquidKv(Q,P1,P2,G,pressureUnit){
			if(Q == ''){
				alert('����������!');
				return;
			}
			if(P1 == ''){
				alert('���������ѹ��!');
				return;
			}
			if(P2 == ''){
				alert('���������ѹ��!');
				return;
			}
			if(G == ''){
				alert('���������!');
				return;
			}			
			
			if(!$.isNumeric(Q)){
				alert('��������������!');
				return;				
			}			
			if(!$.isNumeric(P1)){
				alert('����ѹ������������!');
				return;
			}				
			if(!$.isNumeric(P2)){
				alert('����ѹ������������!');
				return;
			}				
			if(!$.isNumeric(G)){
				alert('���ر���������!');
				return;
			}	
			var numQ = new Number(Q);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numG = new Number(G);
			
			if(numQ <= 0 ){
				alert('�����������0!');
				return;
			}		
			if(numP1 <= numP2){
				alert('����ѹ��������ڳ���ѹ��!');
				return;
			}				
			if(numG <= 0){
				alert('���ر������0!');
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
				alert('����������!');
				return;
			}
			if(P1 == ''){
				alert('���������ѹ��!');
				return;
			}
			if(P2 == ''){
				alert('���������ѹ��!');
				return;
			}
			if(G == ''){
				alert('���������!');
				return;
			}	
			if(T == ''){
				alert('�����������¶�!');
				return;
			}
			
			if(!$.isNumeric(Q)){
				alert('��������������!');
				return;				
			}			
			if(!$.isNumeric(P1)){
				alert('����ѹ������������!');
				return;
			}				
			if(!$.isNumeric(P2)){
				alert('����ѹ������������!');
				return;
			}				
			if(!$.isNumeric(G)){
				alert('���ر���������!');
				return;
			}
			if(!$.isNumeric(T)){
				alert('�����¶ȱ���������!');
				return;
			}
			
			var numQ = new Number(Q);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numG = new Number(G);
			var numT = new Number(T);			
			
			if(numQ <= 0 ){
				alert('�����������0!');
				return;
			}		
			if(numP1 <= numP2){
				alert('����ѹ��������ڳ���ѹ��!');
				return;
			}				
			if(numG <= 0){
				alert('���ر������0!');
				return;
			}	
			if(numT <= -273){
				alert('�����¶ȱ������-273!');
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
				alert('����������!');
				return;
			}
			if(P1 == ''){
				alert('���������ѹ��!');
				return;
			}
			if(P2 == ''){
				alert('���������ѹ��!');
				return;
			}
			if(overT == ''){
				alert('����������¶�!');
				return;
			}			
			
			if(!$.isNumeric(W)){
				alert('��������������!');
				return;				
			}			
			if(!$.isNumeric(P1)){
				alert('����ѹ������������!');
				return;
			}				
			if(!$.isNumeric(P2)){
				alert('����ѹ������������!');
				return;
			}
			if(!$.isNumeric(overT)){
				alert('�����¶ȱ���������!');
				return;
			}
			
			var numW = new Number(W);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numOverT = new Number(overT);			
			
			if(numW <= 0 ){
				alert('�����������0!');
				return;
			}		
			if(numP1 <= numP2){
				alert('����ѹ��������ڳ���ѹ��!');
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
				alert('������ѡ��Kv!');
				return;
			}
			if(Kv == ''){
				alert('���������Kv!');
				return;
			}
			if(R == ''){
				alert('������ɵ���!');
				return;
			}		
			
			if(!$.isNumeric(selectedKv)){
				alert('ѡ��Kv����������!');
				return;				
			}			
			if(!$.isNumeric(Kv)){
				alert('����Kv����������!');
				return;
			}				
			if(!$.isNumeric(R)){
				alert('�ɵ��ȱ���������!');
				return;
			}	
			
			var numSelectedKv = new Number(selectedKv);
			var numKv = new Number(Kv);
			var numR = new Number(R);
			
			if(numSelectedKv <= 0){
				alert('ѡ��Kv�������0!');
				return;
			}
			if(numKv <= 0){
				alert('����Kv�������0!');
				return;
			}
			if(numSelectedKv < numKv){
				alert('ѡ��Kv������ڵ��ڼ���Kv!');
				return;
			}
			if(numR <= 0){
				alert('�ɵ��ȱ������0!');
				return;
			}
			if(numR == 1){
				alert('�ɵ��Ȳ��ܵ���1!');
				return;
			}			
			
			var m = numSelectedKv / numKv;
			return 100 * (1 - (Math.log(m) / Math.log(numR)));
		}
		
		function calculateKByLinear(selectedKv,Kv,R){
			if(selectedKv == ''){
				alert('������ѡ��Kv!');
				return;
			}
			if(Kv == ''){
				alert('���������Kv!');
				return;
			}
			if(R == ''){
				alert('������ɵ���!');
				return;
			}		
			
			if(!$.isNumeric(selectedKv)){
				alert('ѡ��Kv����������!');
				return;				
			}			
			if(!$.isNumeric(Kv)){
				alert('����Kv����������!');
				return;
			}				
			if(!$.isNumeric(R)){
				alert('�ɵ��ȱ���������!');
				return;
			}	
			
			var numSelectedKv = new Number(selectedKv);
			var numKv = new Number(Kv);
			var numR = new Number(R);
			
			if(numSelectedKv <= 0){
				alert('ѡ��Kv�������0!');
				return;
			}
			if(numKv <= 0){
				alert('����Kv�������0!');
				return;
			}
			if(numSelectedKv < numKv){
				alert('ѡ��Kv������ڵ��ڼ���Kv!');
				return;
			}
			if(numR <= 0){
				alert('�ɵ��ȱ������0!');
				return;
			}
			if(numR == 1){
				alert('�ɵ��Ȳ��ܵ���1!');
				return;
			}
			
			var m = numSelectedKv / numKv;
			return 100 * (numR - m) / (m * (numR - 1));
		}
		
		function calculateKByModifiedParabolic(selectedKv,Kv,R){
			if(selectedKv == ''){
				alert('������ѡ��Kv!');
				return;
			}
			if(Kv == ''){
				alert('���������Kv!');
				return;
			}
			if(R == ''){
				alert('������ɵ���!');
				return;
			}		
			
			if(!$.isNumeric(selectedKv)){
				alert('ѡ��Kv����������!');
				return;				
			}			
			if(!$.isNumeric(Kv)){
				alert('����Kv����������!');
				return;
			}				
			if(!$.isNumeric(R)){
				alert('�ɵ��ȱ���������!');
				return;
			}	
			
			var numSelectedKv = new Number(selectedKv);
			var numKv = new Number(Kv);
			var numR = new Number(R);
			
			if(numSelectedKv <= 0){
				alert('ѡ��Kv�������0!');
				return;
			}
			if(numKv <= 0){
				alert('����Kv�������0!');
				return;
			}
			if(numSelectedKv < numKv){
				alert('ѡ��Kv������ڵ��ڼ���Kv!');
				return;
			}
			if(numR <= 0){
				alert('�ɵ��ȱ������0!');
				return;
			}
			if(numR == 1){
				alert('�ɵ��Ȳ��ܵ���1!');
				return;
			}
			
			var m = numSelectedKv / numKv;
			return 100 * (Math.sqrt(numR / m) - 1) / (Math.sqrt(numR) - 1);
		}
		
		function calculateKBySquareRoot(selectedKv,Kv,R){
			if(selectedKv == ''){
				alert('������ѡ��Kv!');
				return;
			}
			if(Kv == ''){
				alert('���������Kv!');
				return;
			}
			if(R == ''){
				alert('������ɵ���!');
				return;
			}		
			
			if(!$.isNumeric(selectedKv)){
				alert('ѡ��Kv����������!');
				return;				
			}			
			if(!$.isNumeric(Kv)){
				alert('����Kv����������!');
				return;
			}				
			if(!$.isNumeric(R)){
				alert('�ɵ��ȱ���������!');
				return;
			}	
			
			var numSelectedKv = new Number(selectedKv);
			var numKv = new Number(Kv);
			var numR = new Number(R);
			
			if(numSelectedKv <= 0){
				alert('ѡ��Kv�������0!');
				return;
			}
			if(numKv <= 0){
				alert('����Kv�������0!');
				return;
			}
			if(numSelectedKv < numKv){
				alert('ѡ��Kv������ڵ��ڼ���Kv!');
				return;
			}
			if(numR <= 1){
				alert('�ɵ��ȱ������1!');
				return;
			}
			
			var m = numSelectedKv / numKv;
			return 100 * ( 1 - Math.sqrt(numR * (m - 1) / (m * (numR - 1))));
		}
		
		
		
		