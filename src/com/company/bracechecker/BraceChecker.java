package com.company.bracechecker;

public class BraceChecker {

    public final String noErrors = "There are no errors";

    private Stack<BraceCheckerItem> stack = new StackImpl<>();
    private boolean parsSuccess;
    private String errorMessage;

    public BraceChecker() {
    }

    public boolean parse(String inputText) {
        int lineNumber = 1;
        int i = 0;
        int numberInLine = 0;
        parsSuccess = true;
        char currentBracket;
        BraceCheckerItem lastElement = null;
        BraceCheckerItem currentItem = null;
        backToThis:
        for (; i < inputText.length(); i++) {
            numberInLine++;
            currentBracket = inputText.charAt(i);

            switch (currentBracket) {
                case '\n':
                case '\r':
                    lineNumber++;
                    numberInLine = 0;
                    break;
                case '(':
                case '{':
                case '[':
                    stack.push(new BraceCheckerItem(i, lineNumber, numberInLine, currentBracket));
                    break;
                case ')':
                    lastElement = stack.pop();
                    if (lastElement == null || lastElement.getValue() != '(') {
                        currentItem = new BraceCheckerItem(i, lineNumber, numberInLine, currentBracket);
                        break backToThis;
                    }
                    break;
                case '}':
                    lastElement = stack.pop();
                    if (lastElement == null || lastElement.getValue() != '{') {
                        currentItem = new BraceCheckerItem(i, lineNumber, numberInLine, currentBracket);
                        break backToThis;
                    }
                    break;
                case ']':
                    lastElement = stack.pop();
                    if (lastElement == null || lastElement.getValue() != '[') {
                        currentItem = new BraceCheckerItem(i, lineNumber, numberInLine, currentBracket);
                        break backToThis;
                    }
                    break;
            }
        }
        validate(inputText, i, lastElement, currentItem);
        return parsSuccess;
    }

    private void validate(String inputText, int i, BraceCheckerItem lastElement, BraceCheckerItem currentItem) {
        if (i < inputText.length()) {
            parsSuccess = false;
            if (lastElement == null) {
                errorMessage = "Closed with " + currentItem + " but not opened";
            } else {
                errorMessage = "Opened with " + lastElement + " but closed with " + currentItem + "'";
            }
        } else if (!stack.isEmpty()) {
            parsSuccess = false;
            BraceCheckerItem element = stack.pop();
            errorMessage = "Opened with " + element + " but not closed";
        }
    }


    public String getErrorMessage() {
        return errorMessage;
    }


}

