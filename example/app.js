function copySound2Sdcard() {
  
  if(Ti.Filesystem.isExternalStoragePresent()){
    
    var name = 'sound';
    var sd_card_path = Ti.Filesystem.externalStorageDirectory;
    
    var new_folder = Ti.Filesystem.getFile(sd_card_path, name);
    if(!new_folder.exists()){
      new_folder.createDirectory();
    }

    var resourcesDirectory = Titanium.Filesystem.getFile(Titanium.Filesystem.resourcesDirectory);
    var folder2Copy = Titanium.Filesystem.getFile(resourcesDirectory.nativePath, name);
        

    var arr = folder2Copy.getDirectoryListing();
    var i = 0;
    
    while(i<arr.length)
    { 
        var sourceFile  = Titanium.Filesystem.getFile(folder2Copy.nativePath, arr[i]);
        var destinationFile = Titanium.Filesystem.getFile(new_folder.nativePath, arr[i]);
        destinationFile.write(sourceFile.read());
        i++;
    }    
  };
}



Ti.UI.createWindow().open();
var push = require('PushNotification');
push.pushNotification();
