public boolean isBracket(char ch) {
		if('(' == ch || ')' == ch || '{' == ch || '}' == ch
			|| '[' == ch || ']' == ch) {
			return true;
		}
		return false;
	}

	public boolean isValid(String str) {
		char[] stack = new char[str.length()];
		int top = 0;
        //开始遍历字符串str
        for (int i = 0;i < str.length();i++) {
        	if(!isBracket(str.charAt(i))) {
        		continue;
        	}else{
        		if(str.charAt(i)=='(' || str.charAt(i)=='{'
        			|| str.charAt(i)=='[') {
        			stack[top++] = str.charAt(i);
        		}else{//可能是右括号
        			if(top == 0) {//右括号多
        				System.out.println("右括号多");
        				return false;
        			}
        			char c = stack[top-1];
        			if ('(' == c && ')' == str.charAt(i) ||
                    '{' == c && '}' == str.charAt(i) ||
                    '[' == c && ']' == str.charAt(i)) {
        				//匹配了一对出栈
        				--top;
                    }else{
                    	System.out.println("右括号次序匹配出错");
                    	return false;
                    }
        		}
        	}
        }
        if(top > 0) {
        	System.out.println("左括号比右括号多");
        	return false;
        }
        System.out.println("左括号===右括号");
        return true;
		}
	}