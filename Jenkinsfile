pipeline {

agent any 

stages{

stage ('single stage for all') {

withMaven (maven:'Maven'){

sh 'mvn clean compile test install'


}



}




}




}