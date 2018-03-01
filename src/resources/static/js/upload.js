cloudinary.setCloudName('library-codecool');

widget = cloudinary.createUploadWidget({ upload_preset: 'a5vxnzbp' },
    function(error, result) {console.log(error, result)});

$('#uploadButton').on('click', function (event) {
    event.preventDefault();
    widget.open();
});
