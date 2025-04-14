# Compiler Project - Phases 1 & 2

## Phase 1: Lexical Analyzer (Scanner)

### Overview
The goal of Phase 1 was to design a lexical analyzer (scanner) for a Java-like language. The analyzer processes input files, identifies tokens based on predefined rules, and prints them alongside their line and row numbers in the console.

### Key Requirements
1. **Case Insensitivity**: The analyzer must be case-insensitive (`Insensitive Case`).
2. **Token Recognition**: The analyzer must automatically distinguish and separate the following tokens:
   - **Numbers**: Integers and decimals (positive/negative), e.g., `0, 7, -821, -0.039, 0.4, +.015, +88, -.61`.
   - **Reserved Words**: e.g., `println, inumber, CLEAR`.
   - **Whitespaces**: Spaces, tabs, etc.
   - **Delimiters**: e.g., `", [, ., ], (, )`.
   - **Operators**: Arithmetic operators (`+, -, *, /, %`), incremental/decremental (`++, --`), and power (`**`).
   - **Comments**: Similar to Java-style comments.
   - **Keywords**: Language-specific keywords.
   - **Identifiers**: Variable/function names.
3. **Input Handling**: The analyzer must accept one or more input files and scan them.
4. **Output**: Identified tokens must be printed to the console with their line and row numbers.

### Implementation Notes
- The scanner mimics Java’s original scanner but with necessary modifications.
- Project submission includes a compressed ZIP file with source code and a `report.pdf` documenting the implementation and execution steps.

---

## Phase 2: Syntax Analyzer (Parser)

### Overview
Phase 2 builds upon the lexical analyzer from Phase 1 to design a syntax analyzer (parser) using the `CUP` tool. The parser validates the structure of the input code against the language’s grammar rules.

### Key Requirements
1. **Language Features**:
   - Variable declarations (`int`, `double`, `float`, `string`).
   - Loop structures (`for`, `do...while`, `while`).
   - Conditional statements (`if`, `else if`, `else`, `switch`).
   - Function definitions.
   - Predefined function `println` to output text or arithmetic results:
     ```java
     // Input:
     println("Hello")  
     // Output:
     Hello
     ```
2. **Arithmetic Operations**: Support for calculations with operator precedence (e.g., multiplication before addition).
3. **CLEAR Command**: Clears the console after `t` seconds (or simulates it with newlines if unsupported).
4. **Variable Assignment (Extra Credit)**:
   ```java
   // Input:
   int x = 1;
   int y = 2;
   println(2*x + y);  
   // Output:
   4
