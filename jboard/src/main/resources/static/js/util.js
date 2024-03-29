function showInputValid(inputs){
    for(const input of inputs){ //inputs 배열에 있는 각 요소에 대해 반복
        input.classList.remove('is-invalid'); //현재 반복 중인 입력 요소의 클래스 목록에서 'is-invalid' 클래스를 제거
        input.classList.add('is-valid'); //'is-valid' 클래스를 입력 요소에 추가하여 유효한 상태로 표시
    }
}

function showInputInValid(inputs){
    for(const input of inputs){ //inputs 배열에 있는 각 요소에 대해 반복
        input.classList.remove('is-invalid'); //현재 반복 중인 입력 요소의 클래스 목록에서 'is-invalid' 클래스를 제거
        input.classList.add('is-valid'); //'is-valid' 클래스를 입력 요소에 추가하여 유효한 상태로 표시
    }
}

function showResultValid(result, message){
    result.classList.remove('invalid-feedback');
    result.classList.add('valid-feedback');
    result.innerText = message;
}

function showResultvalid(result, message){
    result.classList.remove('valid-feedback');
    result.classList.add('invalid-feedback');
    result.innerText = message;
}

function showResultInvalid(result, message){
    result.classList.remove('valid-feedback');
    result.classList.add('invalid-feedback');
    result.innerText = message;
}