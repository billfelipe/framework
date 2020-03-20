# Projeto Glasgow

O objetivo deste projeto é criar uma aplicação capaz de 'predizer' quais conteúdos serão exigidos em novos concursos públicos.
Também são objetivos específicos deste projeto: 
1. Identificar os conteúdos que o candidato já domina e em que grau os domina; 
2. Identificar a diferença entre os conteúdos que o candidato domina e os conteúdos com maior probabilidade de serem exigidos no concurso; 
3. Gerar um plano de estudos com base na diferença identificada; e
4. Gerar um arquivo PDF personalizado, com as questões do banco de questões .

## Processo

1. Concursos serão cadastrados e suas provas serão persistidas no banco de dados
2. As provas serão processadas e divididas em questões
3. As questões serão processadas em linguagem natural, classificando os tokens com part-of-speech e named-entity-recognition
4. O treinamento da inteligência artificial será online e supervisionado. As questões serão classificadas utilizando uma hierarquia de conteúdos.
5. Com o treinamento, a IA será capaz de classificar novas questões, com base nas expressões que considerar significativas
6. Com as questões classificadas, será possível extrair as estatísticas das provas
7. Utilizando heurísticas (ex. provas para juiz/promotor devem ter questões mais difíceis do que as provas para analista/técnico) as questões são classificadas de acordo com o grau de dificuldade
8. As questões serão classificadas por similaridade semântica. No final desse processo, à cada conteúdo será associado um conjunto de questões estruturado na forma de uma árvore balanceada, considerando a dificuldade e a similaridade

