/**
 * 
 */
		//whichCalculation-[kv,maxKv,minKv]
		function calculateLiquidKv(Q,P1,P2,G,pressureUnit,whichCalculation){
			var msg;
			if(Q == ''){				
				if(whichCalculation == 'maxKv')
					msg = '�������������!';
				else if(whichCalculation == 'minKv')
					msg = '��������С����!';
				else
					msg = '����������!';
				alert(msg);
				return;
			}
			if(P1 == ''){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�����뷧ǰѹ��!';
				else
					msg = '���������ѹ��!';
				alert(msg);
				return;
			}
			if(P2 == ''){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�����뷧��ѹ��!';
				else
					msg = '���������ѹ��!';
				alert(msg);
				return;
			}
			if(G == ''){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�������ܶ�!';
				else
					msg = '���������!';				
				alert(msg);
				return;
			}			
			
			if(!$.isNumeric(Q)){
				if(whichCalculation == 'maxKv')
					msg = '�����������������!';
				else if(whichCalculation == 'minKv')
					msg = '��С��������������!';
				else
					msg = '��������������!';
				
				alert(msg);
				return;				
			}			
			if(!$.isNumeric(P1)){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '��ǰѹ������������!';
				else
					msg = '����ѹ������������!';
				
				alert(msg);
				return;
			}				
			if(!$.isNumeric(P2)){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '����ѹ������������!';
				else
					msg = '����ѹ������������!';
				
				alert(msg);
				return;
			}				
			if(!$.isNumeric(G)){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�ܶȱ���������!';
				else
					msg = '���ر���������!';	
				
				alert(msg);
				return;
			}	
			var numQ = new Number(Q);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numG = new Number(G);
			
			if(numQ <= 0 ){
				if(whichCalculation == 'maxKv')
					msg = '��������������0!';
				else if(whichCalculation == 'minKv')
					msg = '��С�����������0!';
				else
					msg = '�����������0!';
				
				alert(msg);
				return;
			}		
			if(numP1 <= numP2){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '��ǰѹ��������ڷ���ѹ��!';
				else
					msg = '����ѹ��������ڳ���ѹ��!';
				
				alert(msg);
				return;
			}				
			if(numG <= 0){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�ܶȱ������0!';
				else
					msg = '���ر������0!';	
				
				alert(msg);
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
		
		function calculateGasCv(Q,P1,P2,G,T,pressureUnit,whichCalculation){
			var msg;
			//alert(Q + ',' + P1 + ',' + P2 + ',' + G + ',' + T)
			if(Q == ''){
				if(whichCalculation == 'maxKv')
					msg = '�������������!';
				else if(whichCalculation == 'minKv')
					msg = '��������С����!';
				else
					msg = '����������!';
				alert(msg);
				return;
			}
			if(P1 == ''){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�����뷧ǰѹ��!';
				else
					msg = '���������ѹ��!';
				
				alert(msg);
				return;
			}
			if(P2 == ''){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�����뷧��ѹ��!';
				else
					msg = '���������ѹ��!';
				
				alert(msg);
				return;
			}
			if(G == ''){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�������ܶ�!';
				else
					msg = '���������!';				
				alert(msg);
				return;
			}	
			if(T == ''){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '����������¶�!';
				else
					msg = '�����������¶�!';
				alert(msg);
				return;
			}
			
			if(!$.isNumeric(Q)){
				if(whichCalculation == 'maxKv')
					msg = '�����������������!';
				else if(whichCalculation == 'minKv')
					msg = '��С��������������!';
				else
					msg = '��������������!';
				
				alert(msg);
				return;				
			}			
			if(!$.isNumeric(P1)){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '��ǰѹ������������!';
				else
					msg = '����ѹ������������!';
				
				alert(msg);
				return;
			}				
			if(!$.isNumeric(P2)){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '����ѹ������������!';
				else
					msg = '����ѹ������������!';
				
				alert(msg);
				return;
			}				
			if(!$.isNumeric(G)){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�ܶȱ���������!';
				else
					msg = '���ر���������!';	
				
				alert(msg);
				return;
			}
			if(!$.isNumeric(T)){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�����¶ȱ���������!';
				else
					msg = '�����¶ȱ���������!';	
				
				alert(msg);
				return;
			}
			
			var numQ = new Number(Q);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numG = new Number(G);
			var numT = new Number(T);			
			
			if(numQ <= 0 ){
				if(whichCalculation == 'maxKv')
					msg = '��������������0!';
				else if(whichCalculation == 'minKv')
					msg = '��С�����������0!';
				else
					msg = '�����������0!';
				
				alert(msg);
				return;
			}		
			if(numP1 <= numP2){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '��ǰѹ��������ڷ���ѹ��!';
				else
					msg = '����ѹ��������ڳ���ѹ��!';
				
				alert(msg);
				return;
			}				
			if(numG <= 0){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�ܶȱ������0!';
				else
					msg = '���ر������0!';	
				
				alert(msg);
				return;
			}	
			if(numT <= -273){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�����¶ȱ������-273!';
				else
					msg = '�����¶ȱ������-273!';
				alert(msg);
				return;
			}			
						
			//alert(pressureUnit);
			if(pressureUnit == 'MPa'){
				numP1 = numP1 * 10;
				numP2 = numP2 * 10;
			}
			else if(pressureUnit == 'KPa'){
				numP1 = numP1 / 100;
				numP2 = numP2 / 100;
			}
			//alert(numP1);
			
			var deltaP = numP1 - numP2;

			//alert(deltaP);
			//alert(Math.sqrt(numG * (273 + numT) / (deltaP * (numP1 + numP2))) * numQ / 287);
			//alert(Math.sqrt(numG * (273 + numT)) * Q / (249 * P1));
			
			if(deltaP < (numP1 / 2)){
				//alert('С');
				return Math.sqrt(numG * (273 + numT) / (deltaP * (numP1 + numP2))) * numQ / 287;
			}
			else{
				//alert('��');
				return Math.sqrt(numG * (273 + numT)) * Q / (249 * numP1);	
			}
										
		}
		
		function calculateVaperCv(W,P1,P2,overT,pressureUnit,whichCalculation){
			if(W == ''){
				if(whichCalculation == 'maxKv')
					msg = '�������������!';
				else if(whichCalculation == 'minKv')
					msg = '��������С����!';
				else
					msg = '����������!';
				alert(msg);
				return;
			}
			if(P1 == ''){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�����뷧ǰѹ��!';
				else
					msg = '���������ѹ��!';
				
				alert(msg);
				return;
			}
			if(P2 == ''){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�����뷧��ѹ��!';
				else
					msg = '���������ѹ��!';
				
				alert(msg);
				return;
			}
			if(overT == ''){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '����������¶�!';
				else
					msg = '����������¶�!';
				alert(msg);

				return;
			}			
			
			if(!$.isNumeric(W)){
				if(whichCalculation == 'maxKv')
					msg = '�����������������!';
				else if(whichCalculation == 'minKv')
					msg = '��С��������������!';
				else
					msg = '��������������!';
				
				alert(msg);
				return;				
			}			
			if(!$.isNumeric(P1)){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '��ǰѹ������������!';
				else
					msg = '����ѹ������������!';
				
				alert(msg);
				return;
			}				
			if(!$.isNumeric(P2)){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '����ѹ������������!';
				else
					msg = '����ѹ������������!';
				
				alert(msg);
				return;
			}
			if(!$.isNumeric(overT)){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '�����¶ȱ���������!';
				else
					msg = '�����¶ȱ���������!';	
				
				alert(msg);
				
				return;
			}
			
			var numW = new Number(W);
			var numP1 = new Number(P1);
			var numP2 = new Number(P2);
			var numOverT = new Number(overT);			
			
			if(numW <= 0 ){
				if(whichCalculation == 'maxKv')
					msg = '��������������0!';
				else if(whichCalculation == 'minKv')
					msg = '��С�����������0!';
				else
					msg = '�����������0!';
				
				alert(msg);
				return;
			}		
			if(numP1 <= numP2){
				if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
					msg = '��ǰѹ��������ڷ���ѹ��!';
				else
					msg = '����ѹ��������ڳ���ѹ��!';
				
				alert(msg);
				return;
			}
				
			if(whichCalculation == 'maxKv' || whichCalculation == 'minKv')
				numOverT = calculateOvertemperature(numP1,numOverT,pressureUnit);
			
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
		
		
		function calculateKByEqualPercentage(selectedKv,Kv,R,whichCalculation){
			//alert(R);
			var msg;
			if(selectedKv == ''){				
				alert('������ѡ��Kv!');
				return;
			}
			if(Kv == ''){
				if(whichCalculation == 'maxKv')
					msg = '���������Kvmax!';
				else if(whichCalculation == 'minKv')
					msg = '���������Kvmin!';
				else
					msg = '���������Kv!';
				
				alert(msg);
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
				alert(kv);
				if(whichCalculation == 'maxKv')
					msg = '����Kvmax����������!';
				else if(whichCalculation == 'minKv')
					msg = '����Kvmin����������!';
				else
					msg = '����Kv����������!';
				
				alert(msg);
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
				if(whichCalculation == 'maxKv')
					msg = '����Kvmax�������0!';
				else if(whichCalculation == 'minKv')
					msg = '����Kvmin�������0!';
				else
					msg = '����Kv�������0!';
				
				alert(msg);
				return;
			}
			if(numSelectedKv < numKv){
				if(whichCalculation == 'maxKv')
					msg = 'ѡ��Kv������ڵ��ڼ���Kvmax!';
				else if(whichCalculation == 'minKv')
					msg = 'ѡ��Kv������ڵ��ڼ���Kvmin!';
				else
					msg = 'ѡ��Kv������ڵ��ڼ���Kv!';
				
				alert(msg);
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
		
		function calculateKByLinear(selectedKv,Kv,R,whichCalculation){
			if(selectedKv == ''){
				alert('������ѡ��Kv!');
				return;
			}
			if(Kv == ''){
				if(whichCalculation == 'maxKv')
					msg = '���������Kvmax!';
				else if(whichCalculation == 'minKv')
					msg = '���������Kvmin!';
				else
					msg = '���������Kv!';
				
				alert(msg);
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
				alert(kv);
				if(whichCalculation == 'maxKv')
					msg = '����Kvmax����������!';
				else if(whichCalculation == 'minKv')
					msg = '����Kvmin����������!';
				else
					msg = '����Kv����������!';
				
				alert(msg);
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
				if(whichCalculation == 'maxKv')
					msg = '����Kvmax�������0!';
				else if(whichCalculation == 'minKv')
					msg = '����Kvmin�������0!';
				else
					msg = '����Kv�������0!';
				
				alert(msg);
				return;
			}
			if(numSelectedKv < numKv){
				if(whichCalculation == 'maxKv')
					msg = 'ѡ��Kv������ڵ��ڼ���Kvmax!';
				else if(whichCalculation == 'minKv')
					msg = 'ѡ��Kv������ڵ��ڼ���Kvmin!';
				else
					msg = 'ѡ��Kv������ڵ��ڼ���Kv!';
				
				alert(msg);
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
		
		function calculateKByModifiedParabolic(selectedKv,Kv,R,whichCalculation){
			if(selectedKv == ''){
				alert('������ѡ��Kv!');
				return;
			}
			if(Kv == ''){
				if(whichCalculation == 'maxKv')
					msg = '���������Kvmax!';
				else if(whichCalculation == 'minKv')
					msg = '���������Kvmin!';
				else
					msg = '���������Kv!';
				
				alert(msg);
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
				if(whichCalculation == 'maxKv')
					msg = '����Kvmax����������!';
				else if(whichCalculation == 'minKv')
					msg = '����Kvmin����������!';
				else
					msg = '����Kv����������!';
				
				alert(msg);
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
				if(whichCalculation == 'maxKv')
					msg = '����Kvmax�������0!';
				else if(whichCalculation == 'minKv')
					msg = '����Kvmin�������0!';
				else
					msg = '����Kv�������0!';
				
				alert(msg);
				return;
			}
			if(numSelectedKv < numKv){
				if(whichCalculation == 'maxKv')
					msg = 'ѡ��Kv������ڵ��ڼ���Kvmax!';
				else if(whichCalculation == 'minKv')
					msg = 'ѡ��Kv������ڵ��ڼ���Kvmin!';
				else
					msg = 'ѡ��Kv������ڵ��ڼ���Kv!';
				
				alert(msg);
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
		
		function calculateKBySquareRoot(selectedKv,Kv,R,whichCalculation){
			if(selectedKv == ''){
				alert('������ѡ��Kv!');
				return;
			}
			if(Kv == ''){
				if(whichCalculation == 'maxKv')
					msg = '���������Kvmax!';
				else if(whichCalculation == 'minKv')
					msg = '���������Kvmin!';
				else
					msg = '���������Kv!';
				
				alert(msg);
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
				if(whichCalculation == 'maxKv')
					msg = '����Kvmax����������!';
				else if(whichCalculation == 'minKv')
					msg = '����Kvmin����������!';
				else
					msg = '����Kv����������!';
				
				alert(msg);
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
				if(whichCalculation == 'maxKv')
					msg = '����Kvmax�������0!';
				else if(whichCalculation == 'minKv')
					msg = '����Kvmin�������0!';
				else
					msg = '����Kv�������0!';
				
				alert(msg);
				return;
			}
			if(numSelectedKv < numKv){
				if(whichCalculation == 'maxKv')
					msg = 'ѡ��Kv������ڵ��ڼ���Kvmax!';
				else if(whichCalculation == 'minKv')
					msg = 'ѡ��Kv������ڵ��ڼ���Kvmin!';
				else
					msg = 'ѡ��Kv������ڵ��ڼ���Kv!';
				
				alert(msg);
				return;
			}
			if(numR <= 1){
				alert('�ɵ��ȱ������1!');
				return;
			}
			
			var m = numSelectedKv / numKv;
			return 100 * ( 1 - Math.sqrt(numR * (m - 1) / (m * (numR - 1))));
		}
		
		
		function calculateOvertemperature(P1,T,pressureUnit){
			if(!$.isNumeric(P1))
				return;
			
			var numP1 = new Number(P1);
			
			if(pressureUnit == 'MPa')
				numP1 = numP1 * 10;
			else if(pressureUnit == 'KPa')
				numP1 = numP1 / 100;
			
			var saturationTemperature;
			if(numP1 < 1){
				alert('����ѹ��С�� 1 kgf/cm2,�����¶Ȱ� ѹ��Ϊ 1 kgf/cm2ʱ��������м���,Ϊ99.1 ��');
				saturationTemperature = 99.1;
			}
			else if(P1 > 220){
				alert('����ѹ������ 220 kgf/cm2,ѹ��̫��,�����¶���0�洦��');
				return 0;
			}
			else						
				saturationTemperature = getSaturationTemperature(numP1);
			
			//alert(saturationTemperature);
			if(!$.isNumeric(saturationTemperature))
				return;			
			
			if(!$.isNumeric(T))
				return;			
			
			var ot = T - saturationTemperature;
			
			//alert(saturationTemperature + ',' + T + ',' + ot);
			return ot;
		}
		
		//P1��λ��kgf/cm2
		function getSaturationTemperature(P1){
			if(!$.isNumeric(P1)){
				//alert('P1 is not a numeric!')
				return;
			}				
			
//			if(P1 < 1){
//				alert('����ѹ��С�� 1 kgf/cm2,�޷�ͨ�����õ������¶�,��������������¶�!');
//				return;
//			}
//			
//			if(P1 > 220){
//				alert('����ѹ������ 220 kgf/cm2,�޷�ͨ�����õ������¶�,��������������¶�!');
//				return;
//			}
			
			var saturationTemperatureTable =
				[{p:1,t:99.1},
				 {p:1.5,t:110.8},
				 {p:2,t:119.6},
				 {p:2.5,t:126.8},
				 {p:3,t:132.9},
				 {p:4,t:142.9},
				 {p:5,t:151.1},
				 {p:6,t:158.1},
				 {p:7,t:164.2},
				 {p:8,t:169.6},
				 {p:9,t:174.5},
				 {p:10,t:179.0},
				 {p:12,t:187.1},
				 {p:14,t:194.1},
				 {p:16,t:200.4},
				 {p:18,t:206.1},
				 {p:20,t:211.4},
				 {p:22,t:216.2},
				 {p:24,t:220.8},
				 {p:26,t:225.0},
				 {p:28,t:229.0},
				 {p:30,t:232.8},
				 {p:32,t:236.4},
				 {p:34,t:239.8},
				 {p:36,t:243.0},
				 {p:38,t:246.2},
				 {p:40,t:249.2},
				 {p:41,t:250.6},
				 {p:42,t:252.1},
				 {p:43,t:253.5},
				 {p:44,t:254.9},
				 {p:45,t:256.3},
				 {p:46,t:257.6},
				 {p:47,t:258.9},
				 {p:48,t:260.2},
				 {p:49,t:261.5},
				 {p:50,t:262.7},
				 {p:52,t:265.2},
				 {p:54,t:267.5},
				 {p:56,t:269.8},
				 {p:58,t:272.1},
				 {p:60,t:274.3},
				 {p:62,t:276.4},
				 {p:64,t:278.5},
				 {p:66,t:280.6},
				 {p:68,t:282.5},
				 {p:70,t:284.5},
				 {p:72,t:286.4},
				 {p:74,t:288.3},
				 {p:76,t:290.1},
				 {p:78,t:291.9},
				 {p:80,t:293.6},
				 {p:82,t:295.3},
				 {p:84,t:297.0},
				 {p:86,t:298.7},
				 {p:88,t:300.3},
				 {p:90,t:301.9},
				 {p:92,t:303.5},
				 {p:94,t:305.0},
				 {p:96,t:306.6},
				 {p:98,t:308.1},
				 {p:100,t:309.5},
				 {p:105,t:313.1},
				 {p:110,t:316.6},
				 {p:115,t:319.0},
				 {p:120,t:323.2},
				 {p:125,t:326.3},
				 {p:130,t:329.3},
				 {p:135,t:332.2},
				 {p:140,t:335.1},
				 {p:145,t:337.9},
				 {p:150,t:340.6},
				 {p:155,t:343.2},
				 {p:160,t:345.8},
				 {p:165,t:348.3},
				 {p:170,t:350.7},
				 {p:175,t:353.3},
				 {p:180,t:355.4},
				 {p:185,t:357.6},
				 {p:190,t:359.8},
				 {p:195,t:362.0},
				 {p:200,t:364.1},
				 {p:210,t:368.2},
				 {p:220,t:372.1}];
			
			for(var i = 0;i < saturationTemperatureTable.length;i++){
				if(P1 == saturationTemperatureTable[i].p)
					return saturationTemperatureTable[i].t;
								
				if(P1 > saturationTemperatureTable[i].p && P1 < saturationTemperatureTable[i + 1].p)					
					return (P1 - saturationTemperatureTable[i].p) < (saturationTemperatureTable[i + 1].p - P1) ? saturationTemperatureTable[i].t : saturationTemperatureTable[i + 1].t;				
			}
		} 
		
		