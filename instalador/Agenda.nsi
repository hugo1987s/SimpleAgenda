;--------------------------------
;Incluimos el Modern UI

  !include "MUI2.nsh"

;--------------------------------
;Propiedades de la interfaz

  !define MUI_ABORTWARNING
  !define NOMBREAPP "Agenda"

;--------------------------------
#General

;Nombre de la aplicaci�n y del ejecutable
   Name "${NOMBREAPP}"
   Icon "agenda.ico"
   OutFile "Agenda.exe"

;Directorio de instalaci�n
   DirText "Elija un directorio donde instalar la aplicaci�n:"
   InstallDir "$PROGRAMFILES\${NOMBREAPP}"

;Obtenemos el directorio del registro (si esta disponible)
   InstallDirRegKey HKCU "Software\Agenda" ""
  
;Indicamos que cuando la instalaci�n se complete no se cierre el instalador autom�ticamente
   AutoCloseWindow false

;Si se encuentran archivos existentes se sobreescriben
   SetOverwrite on
   SetDatablockOptimize on

;--------------------------------
#Paginas
;p�ginas referentes al instalador
  !insertmacro MUI_PAGE_COMPONENTS
  !insertmacro MUI_PAGE_DIRECTORY
  !insertmacro MUI_PAGE_INSTFILES

;p�ginas referentes al desinstalador
  !insertmacro MUI_UNPAGE_CONFIRM
  !insertmacro MUI_UNPAGE_INSTFILES

;--------------------------------
#Lenguajes
;Definimos el idioma del instalador
  !insertmacro MUI_LANGUAGE "Spanish"

;--------------------------------

#Secciones

Section "Agenda" agenda

  SetOutPath "$INSTDIR"
;Hacemos que esta seccion tenga que instalarse obligatoriamente
  SectionIn RO 

;Incluimos todos los archivos que componen nuestra aplicaci�n

  ;Archivos a instalar (solo archivos, los ejecutables van en la secci�n "prerequisitos"
  File agenda.jar
  File "agenda.ico"
  ;File "db.bat"
  ;File "scriptAgenda.sql"

;Menu inicio
  SetShellVarContext all
  createDirectory "$SMPROGRAMS\${NOMBREAPP}"
    createShortCut "$SMPROGRAMS\${NOMBREAPP}\${NOMBREAPP}.lnk" "$INSTDIR\Agenda.jar" "" "$INSTDIR\agenda.ico"
    createShortCut "$SMPROGRAMS\${NOMBREAPP}\Desinstalar.lnk" "$INSTDIR\Uninstall.exe" "" ""
    
;Acceso directo en el escritorio
  CreateShortCut "$DESKTOP\${NOMBREAPP}.lnk" "$INSTDIR\${NOMBREAPP}.jar" "" "$INSTDIR\agenda.ico"
  
;Hacemos que la instalaci�n se realice para todos los usuarios del sistema
  SetShellVarContext all

;Guardamos un registro de la carpeta instalada
  WriteRegStr HKCU "Software\Agenda" "" $INSTDIR
  
;Creamos un desintalador
  WriteUninstaller "$INSTDIR\Uninstall.exe"
SectionEnd


#Seccion desinstalador

Section "Uninstall"

SetShellVarContext all

;Borramos el ejecutable del men� inicio
  delete "$SMPROGRAMS\${NOMBREAPP}\${NOMBREAPP}.lnk"
  delete "$SMPROGRAMS\${NOMBREAPP}\Desinstalar.lnk"

;Borramos el acceso directo del escritorio
  delete "$DESKTOP\${NOMBREAPP}.lnk"

;Intentamos borrar el men� inicio (Solo se puede hacer si la carpeta est� vac�o)
  rmDir "$SMPROGRAMS\${NOMBREAPP}"
 
;Archivos a desinstalar
    delete $INSTDIR\agenda.jar
    delete $INSTDIR\agenda.ico
    ;delete $INSTDIR\db.bat
    ;delete $INSTDIR\scriptAgenda.sql
 
;Borramos el desinstalador
  delete $INSTDIR\Uninstall.exe
 
;Intentamos borrar la carpeta de instalaci�n (Solo se puede si est� vac�a)
  rmDir $INSTDIR

  DeleteRegKey /ifempty HKCU "Agenda"

SectionEnd


#Seccion Prerequisitos, ejecucion de otros instaladores 

Section "Prerequisitos" prerequisitos

SectionIn RO
DetailPrint "Comenzando la instalacion de Mysql Server"     
    File "mysql-5.5.59-winx64.msi"
    ExecWait "msiexec /i mysql-5.5.59-winx64.msi /quiet"
    ExecWait "C:\Program Files\MySQL\MySQL Server 5.5\bin\MySQLInstanceConfig.exe -i -q ServiceName=MySQL RootPassword=123456 ServerType=DEVELOPMENT DatabaseType=INNODB Port=3306 RootCurrentPassword=root"

DetailPrint "Comenzando la instalacion de Java"     
    File "jre-8u162-windows-x64.exe"
    ExecWait "jre-8u162-windows-x64.exe /s"


;DetailPrint "Configurando base de datos"
    ;File "db.bat"
    ;nsExec::Exec "db.bat"

SectionEnd  


;--------------------------------
#Descripciones

  ;Descripcion de Agenda
  LangString DESC_Agenda ${LANG_SPANISH} "Archivos necesarios para la ejecuci�n de la Agenda"

  ;Descripcion de Prerequisitos
  LangString DESC_Prerequisitos ${LANG_SPANISH} "Archivos necesarios para que Agenda funcione correctamente"

  ;Asignamos las descripciones a cada seccion
  !insertmacro MUI_FUNCTION_DESCRIPTION_BEGIN
    !insertmacro MUI_DESCRIPTION_TEXT ${Agenda} $(DESC_Agenda)
    !insertmacro MUI_DESCRIPTION_TEXT ${Prerequisitos} $(DESC_Prerequisitos)
  !insertmacro MUI_FUNCTION_DESCRIPTION_END

;--------------------------------
