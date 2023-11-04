Feature: File Validation From Text to Excel and compared the data

  Scenario: Successfully automated Converted file and comparing thr details
    When user will convert excel "document.xlsx" to text "TextConvertedFromExcel" file
    Then User will do viceVera using delimiter "TextConvertedFromExcel" to "ExcelSheetFromText.xlsx"
    And user compared the both files data and returned result to excel










