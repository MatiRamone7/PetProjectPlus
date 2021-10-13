function imgImpChange() {
    const [file] = document.getElementById("imgInp").files

      if (file) {
        document.getElementById("blah").src = window.URL.createObjectURL(file)
      }
  }