window.onload = function checkIfGameOver() {
    // Get the number of tries left from a hidden or visible HTML element
    var numberOfTriesRemaining = parseInt(document.getElementById('triesLeftElement').textContent);

    if (numberOfTriesRemaining <= 0) {
        alert("Game Over");
        document.getElementById('guessedChar').disabled = true;
        document.getElementById('try').disabled = true;
    }

}

function reloadGame() {
    // Reload the game by navigating to the reload URL
    window.location.href = "/reload";  // Modify this based on your actual reload endpoint
}
