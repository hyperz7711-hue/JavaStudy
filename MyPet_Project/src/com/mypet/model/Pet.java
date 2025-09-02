package com.mypet.model;

// Pet의 정보를 담을 클래스

public class Pet {
	
    private String name;        // 펫의 이름
    private int fullnessScore;  // 포만감
    private int happyScore;     // 즐거움
    private int cleanScore;     // 청결함
    private PetType type;       // 펫의 종류

    public Pet() {}         // 기본생성자

    public Pet(String name, PetType type) {
        this.name = name;
        this.type = type;
        
        // 상태(포만감, 즐거움, 청결함)에 대해서는 기본값으로 초기화
        this.fullnessScore = 50;
        this.happyScore = 50;
        this.cleanScore = 50;
    }



	public void setName(String name) {
		this.name = name;
	}

	public int getFullnessScore() {
		return fullnessScore;
	}

	public void setFullnessScore(int fullnessScore) {
		this.fullnessScore = fullnessScore;
	}

	public int getHappyScore() {
		return happyScore;
	}

	public void setHappyScore(int happyScore) {
		this.happyScore = happyScore;
	}

	public int getCleanScore() {
		return cleanScore;
	}

	public void setCleanScore(int cleanScore) {
		this.cleanScore = cleanScore;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}
    
	/*
	 *  펫이 음식을 먹었을 때 동작할 내용(상태 밴경)
	 */
	
    public void eat()   { 
    	
    	type.eat(this); 
    }
    
	/*
	 *  펫을 놀아주었을 때 상태 변경
	 */   
    public void play()  { 
    	
    	type.play(this); 
    	
    }
	/*
	 *  펫을 목욕시켰을  때 상태 변경
	 */      
    public void clean() {  
    	
    	type.clean(this); 
    	
    } 
    
    public void UpdateFullnessScore(int fullnessScore) {
    	
    	this.fullnessScore += fullnessScore;
    	
    	checkScore();
    }    
    
    public void UpdateHappyScore(int happyScore) {
    	
    	this.happyScore += happyScore;
    	
    	checkScore();
    } 
    
    public void UpdateCleanScore(int cleanScore) {
    	
    	this.cleanScore += cleanScore;  
    	
    	checkScore();
    }    
    
    /** 
     * 펫이 살아 있는지 유무를 확인
     * - 포만감, 즐거움, 청결함 상태가 모두 0인 경우 죽음...
     * @return 살아 있으면 true, 그렇지 않으면 false
     */
    
    public boolean isAlive() {
    	
//    	if (fullnessScore > 0 || this.happyScore > 0 || this.cleanScore > 0 ) {
//        	return true; // TODO:   		
//    	}
//    	else {	
//    	return false; // TODO:
//    	}
    	return (fullnessScore > 0 && this.happyScore > 0 && this.cleanScore > 0 );
    }  
    
    public void passDay() {
    	 
    	UpdateFullnessScore(-5);
    	UpdateHappyScore(-5);
    	UpdateCleanScore(-5);
    }     
    
    public String getStatus() {
    
    	return String.format("[%s 상태] (%s)\n -포만감 : %d\n -즐거움 : %d\n -청결함 : %d"
    			             , name, type.getType()
    			             , fullnessScore, happyScore, cleanScore );
    	
    }    
    
	public String getName() {
		return name; // TODO:
	}  

	/*
	 *  상태값이 범위를 벗어날 경우 처리
	 *  각 상태의 범위 : 0 ~ 100;
	 *  100보다 큰 경우 100으로 설정, 0보다 작을 경우 0으로 설정
	 */
	private void checkScore() {
		
		// 포만감 상태		
		if (fullnessScore > 100) fullnessScore = 100;
		if (fullnessScore < 0) fullnessScore = 0;

		// 즐거움 상태		
		if (happyScore > 100) happyScore = 100;
		if (happyScore < 0) happyScore = 0;
		
		// 청결함 상태		
		if (cleanScore > 100) cleanScore = 100;
		if (cleanScore < 0) cleanScore = 0;		

	}  	
}
