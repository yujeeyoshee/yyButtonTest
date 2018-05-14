# ButtonTest

### Summary
1. Simple button app
2. Instrumentation test in /app/src/androidTest/
3. Jenkinsfile that can be read by Jenkins for pipeline

### For pipeline - Jenkins (TODO: polling every minute is not ideal)

1. New Item
2. Enter an item name yyButtonTestPipeline
3. Pipeline
    General
      - [*] GitHub project
        * URL: https://github.com/yujeeyoshee/yyButtonTest.git
    Build Triggers
      - [*] Poll SCM - Schedule is * * * * *
      - [*] Quiet Period - 5
5. Pipeline
   - Select "Pipeline script from SCM"
   - SCM: Git
     * Repo URL: https://github.com/yujeeyoshee/yyButtonTest.git
     * Credentials: none
     * Branches to build: */master
     * Script Path: Jenkinsfile
     * [*] Lightweight checkout
