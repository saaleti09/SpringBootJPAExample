pipeline {

agent any 

stages{

stage ('single stage for all') {

steps{

withMaven (maven:'Maven'){

sh 'mvn clean compile test install'


}

}



}




}




}