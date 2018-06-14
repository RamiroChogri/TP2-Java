# TP2-Java-informe

\documentclass[titlepage,a4paper]{article}

\usepackage{a4wide}
\usepackage[colorlinks=true,linkcolor=black,urlcolor=blue,bookmarksopen=true]{hyperref}
\usepackage{bookmark}
\usepackage{fancyhdr}
\usepackage[spanish]{babel}
\usepackage[utf8]{inputenc}
\usepackage[T1]{fontenc}
\usepackage{graphicx}
\usepackage{float}

\pagestyle{fancy} % Encabezado y pie de página
\fancyhf{}
\fancyhead[L]{TP2 - Primer Entrega}
\fancyhead[R]{Algoritmos y Programación III - FIUBA}
\renewcommand{\headrulewidth}{0.4pt}
\fancyfoot[C]{\thepage}
\renewcommand{\footrulewidth}{0.4pt}

\begin{document}
\begin{titlepage} % Carátula
  \hfill\includegraphics[width=6cm]{logofiuba.jpg}
    \centering
    \vfill
    \Huge \textbf{Trabajo Práctico 2 — Java - Entrega1}
    \vskip2cm
    \Large [7507/9502] Algoritmos y Programación III\\
    Curso 1 \\ % Curso 1 para el de la tarde y 2 para el de la noche
    Primer cuatrimestre de 2018 
    \vfill
    \begin{tabular}{ | l | l | } % Datos del alumno
      \hline
      Alumno: & Bertillod,Nicolás \\ \hline
      Número de padrón: & 101498 \\ \hline
      Email: & nicolasbertillod@gmail.com \\ \hline
    \end{tabular}
     \begin{tabular}{ | l | l | } % Datos del alumno
      \hline
      Alumno: & Chogri, Ramiro \\ \hline
      Número de padrón: & 100499 \\ \hline
      Email: & ramirochogri@hotmail.com \\ \hline
    \end{tabular}
     \begin{tabular}{ | l | l | } % Datos del alumno
      \hline
      Alumno: & Fandos, Nicolas Gabriel \\ \hline
      Número de padrón: & 101018 \\ \hline
      Email: & nhicof2@gmail.com \\ \hline
    \end{tabular}
     \begin{tabular}{ | l | l | } % Datos del alumno
      \hline
      Alumno: & Ortiz,Benjamin \\ \hline
      Número de padrón: & 100585 \\ \hline
      Email: & benjaortiz969@gmail.com \\ \hline
    \end{tabular}
    \vfill
    \vfill
\end{titlepage}

\tableofcontents % Índice general
\newpage

\section{Introducción}\label{sec:intro}
El presente informe reune la documentación de la solución del tercer trabajo práctico de la materia Algoritmos y Programación III que consiste en desarrollar una aplicación de un sistema de batalla de cartas basado en el juego de yu-gi-oh! en lenguaje Java utilizando los conceptos del paradigma de la orientación a objetos vistos hasta ahora en el curso.

\section{Supuestos}\label{sec:supuestos}
% Deberá contener explicaciones de cada uno de los supuestos que el alumno haya tenido que adoptar a partir de situaciones que no estén contempladas en la especificación.

Suponemos principalmente que los jugadores son conocedores de las reglas de esta adaptacion del juego de cartas Yu-Gi-Oh!, suponemos las limitaciones de la cantidad de cartas que se pueden colocar en el campo, luego suponemos que a la hora de invocar un montruo con mas a 4 estrellas y se debe sacrificar un monstruo ya invocado y se tomará el ultimo o ultimos invocados previamente que aun esten en el campo.


\section{Modelo de dominio}\label{sec:modelo}
% Explicación concisa del diseño general del trabajo.

    \textbf{Carta}: Las diferentes clases que implementan esta interfaz tienen el objetivo de representar los diferentes tipos de carta que hay en Yu-Gi-Oh!.Todas estas cartas pueden ser colocadas en el campo. Estos tipos pueden ser:
    
      
\begin{itemize}
\item \textit{\textbf{CartaMonstruo}}: representa las cartas del tipo monstruo, las cuales pueden realizar ataques a otras cartas del mismo tipo, se pueden colocar de diferentes maneras (en el campo), pueden ser destruidas, etc.    
\item \textit{\textbf{CartaMagica}}: representa las cartas del tipo magicas que pueden colocarse en el campo y tienen un efecto que puede activarse.
\item \textit{\textbf{CartaTrampa}}: representa las cartas del tipo trampa que pueden colocarse en el campo y tienen un efecto que puede activarse.
\end{itemize}


Todos estos tipos de cartas contienen un \textbf{Estado} que puede ir variando de la siguiente manera puede ser del siguiente tipo:
\begin{enumerate}
\item \textit{EstadoCartaEnMazo}: es el estado de una carta cuando esta dentro del mazo
\item \textit{EstadoCartaEnMano} : es el estado de una carta cuando esta en la mano de un jugador.
\item \textit{EstadoCartaEnCementerio}: el estado de una carta cuando se destruye y es enviada al cementerio.
\item \textit{EstadoCartaBocaAbajo}: es el estado de una carta del tipo Magica o Trampa que esta colocada boca abajo en el campo.
\item \textit{EstadoCartaBocaArriba}: es el estado de una carta del tipo Magica o Trampa cuando esta colocada boca arriba en el campo.
\item \textit{EstadoCartaEnModoAtaque}: es el estado de una carta del tipo Monstruo cuando esta colocada 
\item \textit{EstadoCartaBocaArribaEnModoDefensa}: es el estado de una carta del tipo monstruo que esta colocada en el campo en modo de defensa y boca arriba.
\item \textit{EstadoCartaBocaAbajoEnModoDefensa}: es el estado de una carta del tipo monstruo que esta colocada en el campo en modo de defensa y boca abajo.
\end{enumerate}
  
    \textbf{Efecto}: es una interfaz que representa los efectos que pueden tener las diferentes cartas, ya sean del tipo magica, trampa o monstruo.
    
    
    \textbf{Campo}: representa el campo de juego de un unico jugador. Esta clase tiene la responsabilidad de colocar cartas en sus diferentes zonas tanto como retirarlas y colocarlas en otras zonas. También contiene los puntos de vida y el mazo del jugador al que le pertenecen y los modifica a lo largo del duelo. Contiene diferentes zonas:
\begin{itemize}
\item \textit{\textbf{ZonaMonstruo}}: es una clase que representa la parte del campo donde se colocan los monstruos. Tiene las responsabilidades de colocar monstruos tanto como de removerlos. Tiene un limite de 5 monstruos como máximo. Tambien puede calcular cuanto daño deben recibir los puntos de vida cuando se destruyen los monstruos que contiene. También puede responder si contiene cartas y cuantas.
\item \textit{\textbf{ZonaUtilidad}}:  representa la parte del campo donde se colocan las cartas magicas y trampa. Tiene la responsabilidad de colocar dichas cartas tanto como de removerlas. También puede responder si contiene cartas y cuantas.
\item \textit{\textbf{Mazo}}:  es el mazo asociado al campo donde esta contenido. Permite que se tomen cartas y tambien puede responder cuantas cartas contiene.
\end{itemize}
  
    \textbf{Jugador}: una instancia de este tipo representa un jugador que va a participar de un duelo. Contiene un Campo propio y una mano, asi como una referencia la campo del jugador enemigo. Puede colocar cartas en el campo y realizar ataques entre monstruos, tanto como activar cartas magicas/trampa.


\textbf{Mano}: esta clase representa la mano(conjunto de cartas) que un jugador puede ver y colocar en el campo.
\section{Diagramas de clase}\label{sec:diagramasdeclase}
% Uno o varios diagramas de clases mostrando las relaciones estáticas entre las clases.  Puede agregarse todo el texto necesario para aclarar y explicar su diseño. Recuerden que la idea de todo el documento es que quede documentado y entendible cómo está implementada la solución.

Nunc molestie facilisis diam in auctor. Nulla sed porta nibh, eu elementum erat. Vestibulum in lectus ornare, sollicitudin ipsum eget, posuere risus. Duis ac ante sagittis, ornare urna a, scelerisque purus. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut commodo ultricies luctus. In a elit malesuada, semper felis at, varius lorem. Aenean hendrerit vitae lorem sit amet porttitor. Suspendisse vitae vulputate elit, a commodo lacus. Phasellus maximus arcu et eros sollicitudin, eu aliquet nulla efficitur. Aenean semper neque nec dignissim rutrum. Aliquam at purus vel tortor fringilla iaculis sit amet sit amet metus. Pellentesque faucibus a nulla eget molestie.

\begin{figure}[H]
\centering
\includegraphics[width=0.8\textwidth]{diagrama_clase01.png}
\caption{\label{fig:class01}Diagrama del Sudoku.}
\end{figure}

\section{Detalles de implementación}\label{sec:implementacion}
% Explicaciones sobre la implementación interna de algunas clases que consideren que puedan llegar a resultar interesantes.

\subsection{Aliquam vel eros id magna vestibulum rhoncus}
Sed lorem diam, imperdiet in suscipit sed, lacinia id est. Duis ac turpis at velit tristique dictum ac in augue. Etiam porttitor purus sed nunc scelerisque aliquam. In hac habitasse platea dictumst. Mauris non mauris id lorem iaculis elementum eget quis mi. Aliquam scelerisque porta arcu sed tempus. Duis eleifend euismod laoreet. Aliquam mattis lectus et massa placerat feugiat. Nam mi nisl, rhoncus vel nibh vitae, ullamcorper blandit nibh. Curabitur purus lorem, sollicitudin ut erat eu, pharetra condimentum ante. Nullam imperdiet et neque et tempus. Sed sollicitudin velit molestie pretium iaculis. Praesent eu tincidunt erat. Nulla non fringilla nisi, vel hendrerit felis. Maecenas eget tempor neque.

\begin{verbatim}
| rango |
rango := (2 to: 20) asOrderedCollection.
Transcript show: rango ; cr.
rango copy do: [ :unNumero | unNumero isPrime ifFalse: [ rango remove: unNumero ] ].
Transcript show: rango.
\end{verbatim}

\subsection{Proin sodales leo dapibus sapien fermentum}
Quisque tempus, tortor et convallis interdum, ipsum leo tempus ipsum, in molestie tortor arcu sit amet tellus. Praesent fermentum hendrerit nulla. In maximus ornare maximus. Nullam consectetur placerat enim sit amet lacinia. Etiam pellentesque tellus consectetur hendrerit iaculis. Sed non laoreet felis.

\section{Excepciones}\label{sec:excepciones}
% Explicación de cada una de las excepciones creadas y con qué fin fueron creadas.

\begin{description}
\item[NoHayLugarVacioException] Excepcion que surge en el caso excepcional de querer agregar una carta en alguna zona del campo en la cual ya no quedan espacios libres disponibles.
\item[NoHayMonstruoParaSacrificarException] A la hora de querer invocar una carta de monstruo de mas de 4 estrellas es requerido sacrificar una o mas cartas de monstruo que se encuentren colocadas en la zona de monstruos del campo del jugador, esta excepcion se lanza cuando no hay un monstruo para sacrificar y se quiere invocar un monstruo que requiere un sacrificio.
\item[ZonaMonstruoLlenaException] Excepcion que se lanza al querer ubicar una carta de monstruo en la zona de monstruos y esta no contiene ningun espacio disponible para colocar la carta.
\item[ZonaUtilidadLlenaException] Excepcion que se lanza al querer ubicar una carta magica o de trampa en la zona de utilidad y esta no contiene ningun espacio disponible para colocar la carta.
\end{description}

\section{Diagramas de secuencia}\label{sec:diagramasdesecuencia}
% Mostrar las secuencias interesantes que hayan implementado. Pueden agregar texto para explicar si algo no queda claro.

Sed scelerisque est at augue finibus, at faucibus erat venenatis. Phasellus euismod magna mi, nec malesuada quam pretium id. Donec vel diam eleifend, lobortis leo nec, semper sapien. Nunc ultricies mauris augue, id iaculis erat vehicula in. Nam molestie metus vel mi tincidunt lacinia. Nunc a cursus nisl, id sollicitudin mauris. Donec sit amet condimentum dolor, eget rutrum augue.

\begin{figure}[H]
\centering
\includegraphics[width=0.8\textwidth]{diagrama_secuencia01.png}
\caption{\label{fig:seq01}Aliquam rutrum justo sed.}
\end{figure}

Cras est velit, aliquet quis sagittis ornare, volutpat ac risus. Sed ullamcorper tellus orci, non viverra nulla rhoncus nec. Vivamus pretium dui pellentesque dolor molestie facilisis. Pellentesque tristique egestas magna quis tincidunt. Suspendisse non urna dolor. Fusce arcu erat, posuere in nibh at, gravida vulputate ligula. Ut erat erat, facilisis ac tristique eget, mattis sit amet nulla.

Sed ultrices pretium libero eget iaculis. Nulla facilisi. Suspendisse ornare, ligula vitae feugiat faucibus, nisi dolor ullamcorper urna, eu commodo lectus felis fermentum purus. Nunc vitae nunc nec dolor suscipit auctor. Curabitur euismod, leo non consequat congue, nibh ex aliquam urna, eget condimentum lectus urna venenatis magna. Praesent egestas sodales nibh, ut posuere ante vulputate sed. Vivamus gravida, orci sit amet auctor interdum, felis ipsum dapibus massa, sed commodo nisi risus ac nibh. Nunc ac viverra massa. Phasellus tempor arcu sapien, sit amet blandit velit bibendum non.

Duis est eros, laoreet viverra molestie ac, fringilla eget sapien. Sed molestie consequat sem non ultrices. Nulla sed velit nisl. Nunc luctus at neque et vehicula. Nulla feugiat velit in vestibulum rhoncus. Integer lobortis accumsan massa condimentum eleifend. Donec condimentum mauris sit amet purus bibendum, id bibendum odio pretium. Ut sollicitudin tellus vel nibh viverra, et aliquam ipsum iaculis. Duis tellus eros, sodales in aliquam vestibulum, porttitor tempus ipsum. Maecenas ac tincidunt nisl, et placerat leo. Fusce sit amet lectus nisl.

\begin{figure}[H]
\centering
\includegraphics[width=\textwidth]{diagrama_secuencia02.png}
\caption{\label{fig:seq02}Nam a nulla non mauris ullamcorper.}
\end{figure}

Donec efficitur, sapien quis consectetur bibendum, metus magna finibus metus, id venenatis dolor est eu tortor. Phasellus pellentesque, leo quis placerat ornare, sem purus porttitor enim, ac consectetur neque magna id ante. Donec tempor urna nisl, eget convallis elit aliquet sit amet. Phasellus turpis ex, malesuada vel tellus in, blandit suscipit diam. Vestibulum pulvinar leo a ornare laoreet. Vivamus volutpat velit dui, ac accumsan enim iaculis ac. Duis commodo a nulla et consectetur.

Sed sed diam in elit vulputate ultricies. Sed at felis mauris. Proin turpis est, sollicitudin ac arcu ac, blandit hendrerit est. Duis eu sagittis purus. Sed blandit dolor molestie justo sagittis pulvinar. Donec consequat urna at nunc finibus ullamcorper. Nam nulla nibh, vehicula id feugiat id, hendrerit a dolor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Fusce nec orci ut nibh convallis suscipit id sed est. Aenean placerat, est eget vehicula posuere, est eros pretium mi, sed porttitor nibh augue eget odio. Nulla mi lacus, placerat tincidunt magna non, suscipit lobortis urna.

Duis consequat varius sem, eu vehicula ex interdum quis. Integer consequat massa et fermentum tincidunt. Nam rutrum vestibulum nunc, eget tempus ex condimentum eget. Nunc id sollicitudin lectus. Vivamus porta sodales nisl nec tempor. Ut rhoncus accumsan sem eu consequat. Suspendisse eu metus a tellus convallis pharetra. Donec hendrerit, sapien a egestas iaculis, justo ante sodales elit, sed finibus ex purus a massa. Vivamus quis libero velit. Sed in ornare odio, ac facilisis magna. Donec rutrum orci ligula, nec interdum ipsum tristique ut. Vestibulum non orci finibus, hendrerit sem convallis, sagittis nunc. Aliquam vel laoreet dolor. Vivamus dignissim commodo magna, quis vestibulum libero aliquet nec. Praesent malesuada porta neque varius dictum.

\end{document}
